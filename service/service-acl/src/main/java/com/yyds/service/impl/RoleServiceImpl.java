package com.yyds.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yyds.base.BaseMapper;
import com.yyds.base.BaseServiceImpl;
import com.yyds.entity.Role;
import com.yyds.mapper.RoleMapper;
import com.yyds.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: RoleServiceImpl
 * @Author: yyd
 * @Date: 2022/5/23
 * @Description:
 */

@Service(interfaceClass = RoleService.class)
@Transactional(propagation = Propagation.REQUIRED)
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    /**
     * 查询所有角色
     */
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }


    @Override
    protected BaseMapper<Role> getEntityMapper() {
        return roleMapper;
    }
}
