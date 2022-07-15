package com.yyds.mapper;

import com.github.pagehelper.Page;
import com.yyds.base.BaseMapper;
import com.yyds.entity.House;
import com.yyds.entity.bo.HouseQueryBo;
import com.yyds.entity.vo.HouseVo;

/**
 * @ClassName: HouseMapper
 * @Author: yyd
 * @Date: 2022/5/24
 * @Description:
 */
public interface HouseMapper extends BaseMapper<House> {

    Page<HouseVo> findListPage(HouseQueryBo houseQueryBo);
}
