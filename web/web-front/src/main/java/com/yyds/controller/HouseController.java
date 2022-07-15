package com.yyds.controller;
/**
 * @ClassName: HouseController
 * @Author: yyd
 * @Date: 2022/5/27
 * @Description:
 */

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.yyds.entity.Community;
import com.yyds.entity.House;
import com.yyds.entity.HouseBroker;
import com.yyds.entity.HouseImage;
import com.yyds.entity.bo.HouseQueryBo;
import com.yyds.entity.vo.HouseVo;
import com.yyds.result.Result;
import com.yyds.service.CommunityService;
import com.yyds.service.HouseBrokerService;
import com.yyds.service.HouseImageService;
import com.yyds.service.HouseService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: HouseController
 * @Author: yyd
 * @Date: 2022/5/27
 * @Description:
 */
@RestController
@RequestMapping("/house")
public class HouseController {
    @Reference
    private HouseService houseService;
    @Reference
    private CommunityService communityService;
    @Reference
    private HouseBrokerService houseBrokerService;

    @Reference
    private HouseImageService houseImageService;

    @PostMapping("/list/{pageNum}/{pageSize}")
    public Result findListPage(@RequestBody HouseQueryBo houseQueryBo,
                               @PathVariable("pageNum") Integer pageNum,
                               @PathVariable("pageSize") Integer pageSize){
        PageInfo<HouseVo> pageInfo = houseService.findListPage(pageNum, pageSize, houseQueryBo);
        return Result.ok(pageInfo);
    }

    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") Long id, HttpSession session){
        //1. 查询房源信息
        House house = houseService.getById(id);
        //2. 查询小区信息
        Community community = communityService.getById(house.getCommunityId());
        //3. 查询经纪人列表信息
        List<HouseBroker> houseBrokerList = houseBrokerService.findHouseBrokerListByHouseId(id);
        //4. 获取房产列表信息
        List<HouseImage> houseImage1List = houseImageService.findHouseImageList(id, 1);

        Map<String, Object> map = new HashMap<>();
        map.put("house",house);
        map.put("community",community);
        map.put("houseBrokerList",houseBrokerList);
        map.put("houseImage1List",houseImage1List);
        //关注业务: 现在不做，明天完成，现在先设置为false
        map.put("isFollow",false);
        return Result.ok(map);
    }
}
