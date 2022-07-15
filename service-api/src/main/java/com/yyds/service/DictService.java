package com.yyds.service;

import com.yyds.entity.Dict;

import java.util.List;
import java.util.Map;

public interface DictService {
    /**
     * 根据父节点id查子节点列表
     * @param id
     * @return
     */
    List<Map<String,Object>> findZnodes(Long id);

    /**
     * 根据dictCode查询dict集合
     * @param parentDictCode
     * @return
     */
    List<Dict> findDictListByParentDictCode(String parentDictCode);

    /**
     * 根据父节点查询其所有的子节点
     * @param parentId
     * @return
     */
    List<Dict> findDictListByParentId(Long parentId);
}
