package com.yyds.controller;
/**
 * @ClassName: DictController
 * @Author: yyd
 * @Date: 2022/5/24
 * @Description:
 */

import com.alibaba.dubbo.config.annotation.Reference;
import com.yyds.base.BaseController;
import com.yyds.entity.Dict;
import com.yyds.result.Result;
import com.yyds.service.DictService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: DictController
 * @Author: yyd
 * @Date: 2022/5/24
 * @Description:
 */
@RestController
@RequestMapping("/dict")
public class DictController extends BaseController{
    @Reference
    private DictService dictService;
    @GetMapping("/findZnodes")
    public Result findZnodes(@RequestParam(value = "id",defaultValue = "0") Long id){
        List<Map<String, Object>> znodes = dictService.findZnodes(id);
        return Result.ok(znodes);
    }

    /**
     * 根据父节点的id获取子节点数据列表
     * @param parentId
     * @return
     */
    @RequestMapping("/findDictListByParentId/{parentId}")
    public Result findDictListByParentId(@PathVariable("parentId") Long parentId){
        //调用业务层方法根据父节点查询子节点列表
        List<Dict> dictList = dictService.findDictListByParentId(parentId);
        //将数据封装到Result中返回
        return Result.ok(dictList);
    }
}
