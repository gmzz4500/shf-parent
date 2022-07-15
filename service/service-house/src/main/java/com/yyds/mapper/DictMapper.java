package com.yyds.mapper;

import com.yyds.entity.Dict;

import java.util.List;

public interface DictMapper {
    /**
     * 根据父节点id查询子节点列表
     * @param parentId
     * @return
     */
    List<Dict> findListByParentId(Long parentId);

    /**
     * 判断是否是父节点
     * @param id
     * @return
     */
    Integer countIsParent(Long id);

    /**
     * 根据父节点的dictCode查询子节点列表
     * @param parentDictCode
     * @return
     */
    List<Dict> findDictListByParentDictCode(String parentDictCode);
}
