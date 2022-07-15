package com.yyds.service;

import com.yyds.base.BaseService;
import com.yyds.entity.Role;

import java.util.List;

public interface RoleService extends BaseService<Role> {
    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();

}
