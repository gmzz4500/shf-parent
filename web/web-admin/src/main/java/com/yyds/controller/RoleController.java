package com.yyds.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.yyds.base.BaseController;
import com.yyds.entity.Role;
import com.yyds.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: RoleController
 * @Author: yyd
 * @Date: 2022/5/23
 * @Description:
 */
@Controller
@RequestMapping(value="/role")
public class RoleController extends BaseController {
    @Reference
    private RoleService roleService;
    private final static String PAGE_INDEX = "role/index";
    private final static String PAGE_EDIT = "role/edit";
    private final static String LIST_ACTION = "redirect:/role";
    /**
     * 全部的列表 改成分页显示
     * @param model
     * @return
     */
    @RequestMapping
    public String index(@RequestParam Map filters, Model model) {
        if(!filters.containsKey("pageNum")){
            filters.put("pageNum",1);
        }
        if(!filters.containsKey("pageSize")){
            filters.put("pageSize",10);
        }
        PageInfo<Role> pageInfo = roleService.findPage(filters);
        model.addAttribute("page",pageInfo);
        model.addAttribute("filters",filters);
        return PAGE_INDEX;
    }

    /**
     * 保存新增的角色信息
     * @param role
     * @param model
     * @return
     */
    @PostMapping("/save")
    public String save(Role role,Model model) {
        roleService.insert(role);
        return successPage(model,"添加角色成功");
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id,Model model){
        //调用业务层的方法根据id查询角色信息
        Role role = roleService.getById(id);
        model.addAttribute("role",role);
        return PAGE_EDIT;
    }

    @PostMapping(value="/update")
    public String update(Role role,Model model){
        //调用业务层的方法修改角色信息
        roleService.update(role);
        return successPage(model,"更新角色成功");
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        roleService.delete(id);
        return LIST_ACTION;
    }
}
