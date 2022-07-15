package com.yyds.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.yyds.base.BaseController;
import com.yyds.entity.Admin;
import com.yyds.service.AdminService;
import com.yyds.util.FileUtil;
import com.yyds.util.QiniuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * @ClassName: AdminController
 * @Author: yyd
 * @Date: 2022/5/23
 * @Description:
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {
    @Reference
    private AdminService adminService;
    private final static String PAGE_INDEX = "admin/index";
    private final static String PAGE_EDIT = "admin/edit";
    private final static String LIST_ACTION = "redirect:/admin";
    private final static String PAGE_UPLOAD_SHOW = "admin/upload";
    @RequestMapping
    public String index(@RequestParam Map<String,Object> filters,Model model){
        PageInfo<Admin> pageInfo = adminService.findPage(filters);
        model.addAttribute("page",pageInfo);
        model.addAttribute("filters",filters);
        return PAGE_INDEX;
    }

    //添加用户信息
    @PostMapping("/save")
    public String save(Admin admin,Model model){
        adminService.insert(admin);
        return successPage(model,"新增用户成功");
    }

    //根据id查询要修改的用户信息
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id,Model model){
        Admin admin = adminService.getById(id);
        model.addAttribute("admin",admin);
        return PAGE_EDIT;
    }

    @PostMapping("/update")
    public String update(Admin admin,Model model){
        adminService.update(admin);
        return successPage(model,"编辑用户成功");
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        adminService.delete(id);
        return LIST_ACTION;
    }

    @GetMapping("/uploadShow/{id}")
    public String uploadShow(@PathVariable("id") Long id,Model model){
        model.addAttribute("id",id);

        return PAGE_UPLOAD_SHOW;
    }

    @PostMapping("/upload/{id}")
    public String upload(@PathVariable("id") Long id,
                         @RequestParam("file") MultipartFile multipartFile,
                         Model model) throws IOException {
        //id是用户的id
        //1. 将图片上传到七牛云
        //生成一个唯一的文件名
        String originalFilename = multipartFile.getOriginalFilename();
        String uuidName = FileUtil.getUUIDName(originalFilename);
        QiniuUtils.upload2Qiniu(multipartFile.getBytes(),uuidName);

        //2. 将图片信息保存到数据库
        //2.1 获取图片的url
        String headUrl = QiniuUtils.getUrl(uuidName);
        //2.2 封装信息到Admin
        Admin admin = new Admin();
        admin.setId(id);
        admin.setHeadUrl(headUrl);
        //2.3 更新admin
        adminService.update(admin);

        //3. 显示成功页面
        return successPage(model,"上传头像成功");
    }

}
