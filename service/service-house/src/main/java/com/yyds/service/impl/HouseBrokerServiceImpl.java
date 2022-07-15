package com.yyds.service.impl;
/**
 * @ClassName: HouseBrokerServiceImpl
 * @Author: yyd
 * @Date: 2022/5/25
 * @Description:
 */

import com.alibaba.dubbo.config.annotation.Service;
import com.yyds.base.BaseMapper;
import com.yyds.base.BaseServiceImpl;
import com.yyds.entity.HouseBroker;
import com.yyds.mapper.HouseBrokerMapper;
import com.yyds.service.HouseBrokerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName: HouseBrokerServiceImpl
 * @Author: yyd
 * @Date: 2022/5/25
 * @Description:
 */
@Service(interfaceClass = HouseBrokerService.class)
public class HouseBrokerServiceImpl extends BaseServiceImpl<HouseBroker> implements HouseBrokerService {
    @Autowired
    private HouseBrokerMapper houseBrokerMapper;
    @Override
    protected BaseMapper<HouseBroker> getEntityMapper() {
        return houseBrokerMapper;
    }

    @Override
    public List<HouseBroker> findHouseBrokerListByHouseId(Long houseId) {
        return houseBrokerMapper.findHouseBrokerListByHouseId(houseId);
    }
}
