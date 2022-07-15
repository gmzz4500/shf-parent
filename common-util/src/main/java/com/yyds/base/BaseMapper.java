package com.yyds.base;

import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: BaseMapper
 * @Author: yyd
 * @Date: 2022/5/23
 * @Description:
 */
public interface BaseMapper<T> {
    /**
     * 保存一个实体
     *
     * @param t
     */
    void insert(T t);

    /**
     * 批量添加
     * @param list
     */
    void insertBatch(List<T> list);

    /**
     * 删除
     *
     * @param id 标识ID 可以是自增长ID，也可以是唯一标识。
     */
    void delete(Long id);

    /**
     * 更新一个实体
     *
     * @param t
     */
    void update(T t);

    /**
     * 通过一个标识ID 获取一个唯一实体
     *
     * @param id 标识ID 可以是自增长ID，也可以是唯一标识。
     * @return
     */
    T getById(Long id);

    /**
     * 分页查询
     * @param filters
     * @return
     */
    Page<T> findPage(Map<String, Object> filters);
}
