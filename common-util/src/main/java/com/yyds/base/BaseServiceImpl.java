package com.yyds.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyds.util.CastUtil;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @ClassName: BaseServiceImpl
 * @Author: yyd
 * @Date: 2022/5/23
 * @Description:
 */
public abstract class BaseServiceImpl<T> {
    /**
     * 获取mapper对象
     * @return
     */
    protected abstract BaseMapper<T> getEntityMapper();
    public void insert(T t) {
        getEntityMapper().insert(t);
    }

    public void delete(Long id) {
        getEntityMapper().delete(id);
    }

    public void update(T t) {
        getEntityMapper().update(t);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public T getById(Long id) {
        return getEntityMapper().getById(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public PageInfo<T> findPage(Map<String, Object> filters) {
        //当前页数
        int pageNum = CastUtil.castInt(filters.get("pageNum"), 1);
        //每页显示的记录条数
        int pageSize = CastUtil.castInt(filters.get("pageSize"), 10);
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<T>(getEntityMapper().findPage(filters), 10);
    }
}
