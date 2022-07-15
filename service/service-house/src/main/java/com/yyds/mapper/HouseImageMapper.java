package com.yyds.mapper;

import com.yyds.base.BaseMapper;
import com.yyds.entity.HouseImage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: HouseImageMapper
 * @Author: yyd
 * @Date: 2022/5/25
 * @Description:
 */
public interface HouseImageMapper extends BaseMapper<HouseImage> {
    /**
     * 根据房源id和type查询房源的图片列表
     * @param houseId
     * @param type
     * @return
     */
    List<HouseImage> findHouseImageList(@Param("houseId") Long houseId,@Param("type") Integer type);
}
