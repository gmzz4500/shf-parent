package com.yyds.mapper;

import com.yyds.base.BaseMapper;
import com.yyds.entity.HouseBroker;

import java.util.List;

/**
 * @ClassName: HouseBrokerMapper
 * @Author: yyd
 * @Date: 2022/5/25
 * @Description:
 */
public interface HouseBrokerMapper extends BaseMapper<HouseBroker> {
    /**
     * 根据房源id查询房源的经纪人列表
     * @param houseId
     * @return
     */
    List<HouseBroker> findHouseBrokerListByHouseId(Long houseId);
}
