package com.yyds.mapper;

import com.yyds.base.BaseMapper;
import com.yyds.entity.Community;

import java.util.List;

/**
 * @ClassName: CommunityMapper
 * @Author: yyd
 * @Date: 2022/5/24
 * @Description:
 */
public interface CommunityMapper extends BaseMapper<Community> {
    //查询所有
    List<Community> findAll();
}
