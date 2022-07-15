package com.yyds.service.impl;
/**
 * @ClassName: HouseUserServiceImpl
 * @Author: yyd
 * @Date: 2022/5/25
 * @Description:
 */

import com.alibaba.dubbo.config.annotation.Service;
import com.yyds.base.BaseMapper;
import com.yyds.base.BaseServiceImpl;
import com.yyds.entity.HouseUser;
import com.yyds.mapper.HouseUserMapper;
import com.yyds.service.HouseUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName: HouseUserServiceImpl
 * @Author: yyd
 * @Date: 2022/5/25
 * @Description:
 */
@Service(interfaceClass = HouseUserService.class)
public class HouseUserServiceImpl extends BaseServiceImpl<HouseUser> implements HouseUserService {
    @Autowired
    private HouseUserMapper houseUserMapper;
    @Override
    protected BaseMapper<HouseUser> getEntityMapper() {
        return houseUserMapper;
    }

    @Override
    public List<HouseUser> findHouseUserListByHouseId(Long houseId) {
        return houseUserMapper.findHouseUserListByHouseId(houseId);
    }
}
