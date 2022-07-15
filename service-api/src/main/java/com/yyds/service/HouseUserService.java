package com.yyds.service;

import com.yyds.base.BaseService;
import com.yyds.entity.HouseUser;

import java.util.List;

/**
 * @ClassName: HouseUserService
 * @Author: yyd
 * @Date: 2022/5/25
 * @Description:
 */
public interface HouseUserService extends BaseService<HouseUser> {
    /**
     * 根据房源id查询房源的房东列表
     * @param houseId
     * @return
     */
    List<HouseUser> findHouseUserListByHouseId(Long houseId);
}
