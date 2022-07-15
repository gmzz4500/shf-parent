package com.yyds.service;

import com.yyds.base.BaseService;
import com.yyds.entity.Community;

import java.util.List;

/**
 * @ClassName: CommunityService
 * @Author: yyd
 * @Date: 2022/5/24
 * @Description:
 */
public interface CommunityService extends BaseService<Community> {
    //查询所有小区
    List<Community> findAll();
}
