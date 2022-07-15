package com.yyds.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yyds.base.BaseMapper;
import com.yyds.base.BaseServiceImpl;
import com.yyds.entity.Admin;
import com.yyds.mapper.AdminMapper;
import com.yyds.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: AdminServiceImpl
 * @Author: yyd
 * @Date: 2022/5/23
 * @Description:
 */
@Service(interfaceClass = AdminService.class)
@Transactional(propagation = Propagation.REQUIRED)
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    protected BaseMapper<Admin> getEntityMapper() {
        return adminMapper;
    }
}
