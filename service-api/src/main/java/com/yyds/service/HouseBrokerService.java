package com.yyds.service;

import com.yyds.base.BaseService;
import com.yyds.entity.HouseBroker;

import java.util.List;

/**
 * @ClassName: HouseBrokerService
 * @Author: yyd
 * @Date: 2022/5/25
 * @Description:
 */
public interface HouseBrokerService extends BaseService<HouseBroker> {
    /**
     * 根据房源id查询房源的经纪人列表
     * @param houseId
     * @return
     */
    List<HouseBroker> findHouseBrokerListByHouseId(Long houseId);
}
