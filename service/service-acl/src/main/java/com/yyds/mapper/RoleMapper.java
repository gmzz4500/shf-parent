package com.yyds.mapper;

import com.yyds.base.BaseMapper;
import com.yyds.entity.Role;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {
    //查找全部
    List<Role> findAll();

}
