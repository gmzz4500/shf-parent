package com.yyds.service.impl;
/**
 * @ClassName: CommunityServiceImpl
 * @Author: yyd
 * @Date: 2022/5/24
 * @Description:
 */

import com.alibaba.dubbo.config.annotation.Service;
import com.yyds.base.BaseMapper;
import com.yyds.base.BaseServiceImpl;
import com.yyds.entity.Community;
import com.yyds.mapper.CommunityMapper;
import com.yyds.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName: CommunityServiceImpl
 * @Author: yyd
 * @Date: 2022/5/24
 * @Description:
 */
@Service(interfaceClass = CommunityService.class)
public class CommunityServiceImpl extends BaseServiceImpl<Community> implements CommunityService {
    @Autowired
    private CommunityMapper communityMapper;
    @Override
    protected BaseMapper<Community> getEntityMapper() {
        return communityMapper;
    }

    @Override
    public List<Community> findAll() {
        return communityMapper.findAll();
    }
}
