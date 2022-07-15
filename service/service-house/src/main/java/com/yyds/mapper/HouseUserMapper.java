package com.yyds.mapper;

import com.yyds.base.BaseMapper;
import com.yyds.entity.HouseUser;

import java.util.List;

/**
 * @ClassName: HouseUserMapper
 * @Author: yyd
 * @Date: 2022/5/25
 * @Description:
 */
public interface HouseUserMapper extends BaseMapper<HouseUser> {
    /**
     * 根据房源id查询房源的房东列表
     * @param houseId
     * @return
     */
    List<HouseUser> findHouseUserListByHouseId(Long houseId);
}
