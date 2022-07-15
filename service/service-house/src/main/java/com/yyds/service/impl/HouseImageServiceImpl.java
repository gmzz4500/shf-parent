package com.yyds.service.impl;
/**
 * @ClassName: HouseImageServiceImpl
 * @Author: yyd
 * @Date: 2022/5/25
 * @Description:
 */

import com.alibaba.dubbo.config.annotation.Service;
import com.yyds.base.BaseMapper;
import com.yyds.base.BaseServiceImpl;
import com.yyds.entity.HouseImage;
import com.yyds.mapper.HouseImageMapper;
import com.yyds.service.HouseImageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName: HouseImageServiceImpl
 * @Author: yyd
 * @Date: 2022/5/25
 * @Description:
 */
@Service(interfaceClass = HouseImageService.class)
public class HouseImageServiceImpl extends BaseServiceImpl<HouseImage> implements HouseImageService {
    @Autowired
    private HouseImageMapper houseImageMapper;
    @Override
    protected BaseMapper getEntityMapper() {
        return houseImageMapper;
    }

    @Override
    public List<HouseImage> findHouseImageList(Long houseId, Integer type) {
        return houseImageMapper.findHouseImageList(houseId,type);
    }
}
