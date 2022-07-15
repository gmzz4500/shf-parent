package com.yyds.base;

import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface BaseService<T> {
    void insert(T t);

    void delete(Long id);

    void update(T t);

    T getById(Long id);

    PageInfo<T> findPage(Map<String, Object> filters);
}
