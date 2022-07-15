package com.yyds.service;

import com.yyds.base.BaseService;
import com.yyds.entity.HouseImage;

import java.util.List;

/**
 * @ClassName: HouseImageService
 * @Author: yyd
 * @Date: 2022/5/25
 * @Description:
 */
public interface HouseImageService extends BaseService<HouseImage> {
    /**
     * 根据id查询房源的房源图片列表
     * @param houseId
     * @param type
     * @return
     */
    List<HouseImage> findHouseImageList(Long houseId,Integer type);
}
