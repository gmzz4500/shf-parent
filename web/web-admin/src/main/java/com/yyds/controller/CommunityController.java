package com.yyds.controller;
/**
 * @ClassName: CommunityController
 * @Author: yyd
 * @Date: 2022/5/24
 * @Description:
 */

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.yyds.base.BaseController;
import com.yyds.entity.Community;
import com.yyds.entity.Dict;
import com.yyds.service.CommunityService;
import com.yyds.service.DictService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: CommunityController
 * @Author: yyd
 * @Date: 2022/5/24
 * @Description:
 */
@Controller
@RequestMapping("/community")
public class CommunityController extends BaseController {
    @Reference
    private CommunityService communityService;
    @Reference
    private DictService dictService;
    private final static String PAGE_INDEX = "community/index";
    private final static String PAGE_CREATE = "community/create";
    private final static String PAGE_EDIT = "community/edit";
    private final static String LIST_ACTION = "redirect:/community";

    @RequestMapping
    public String index(@RequestParam Map<String,Object> filters, Model model){
        //处理pageNum和pageSize为空的情况
        if (filters.get("pageNum") == null || "".equals(filters.get("pageNum"))) {
            filters.put("pageNum",1);
        }
        if (filters.get("pageSize") == null || "".equals(filters.get("pageSize"))) {
            filters.put("pageSize",10);
        }
        //查询"beijing"的所有区域
        List<Dict> areaList = dictService.findDictListByParentDictCode("beijing");
        PageInfo<Community> pageInfo = communityService.findPage(filters);
        //将分页数据存储到请求域
        model.addAttribute("page",pageInfo);
        //将搜索条件存储到请求域

        //处理filters中没有areaId和plateId的情况
        if (!filters.containsKey("areaId")){
            filters.put("areaId",0);
        }
        if (!filters.containsKey("plateId")){
            filters.put("plateId",0);
        }
        model.addAttribute("filters",filters);
        //将areaList存储到请求域
        model.addAttribute("areaList",areaList);
        return PAGE_INDEX;
    }
    @RequestMapping("/create")
    public String create(Model model){
        List<Dict> areaList = dictService.findDictListByParentDictCode("beijing");
        model.addAttribute("areaList",areaList);
        return PAGE_CREATE;
    }

    //保存新增小区功能
    @PostMapping("/save")
    public String save(Community community,Model model){
        communityService.insert(community);
        return successPage(model,"添加小区成功");
    }

    //修改小区功能
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable("id") Long id,Model model){
        //查询小区信息
        Community community = communityService.getById(id);
        model.addAttribute("community",community);
        //查询beijing所有的区域
        List<Dict> areaList = dictService.findDictListByParentDictCode("beijing");
        model.addAttribute("areaList",areaList);
        return PAGE_EDIT;
    }

    //保存修改功能
    @PostMapping("/update")
    public String update(Community community,Model model){
        communityService.update(community);
        return successPage(model,"修改小区信息成功");
    }

    //删除小区功能
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        communityService.delete(id);
        return LIST_ACTION;
    }
}
