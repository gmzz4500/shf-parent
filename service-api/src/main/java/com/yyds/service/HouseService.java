package com.yyds.service;

import com.github.pagehelper.PageInfo;
import com.yyds.base.BaseService;
import com.yyds.entity.House;
import com.yyds.entity.bo.HouseQueryBo;
import com.yyds.entity.vo.HouseVo;

/**
 * @ClassName: HouseService
 * @Author: yyd
 * @Date: 2022/5/24
 * @Description:
 */
public interface HouseService extends BaseService<House> {

    //发布房源
    void publish(Long id,Integer status);

    //查询房源列表
    PageInfo<HouseVo> findListPage(int pageNum, int pageSize, HouseQueryBo houseQueryBo);
}
