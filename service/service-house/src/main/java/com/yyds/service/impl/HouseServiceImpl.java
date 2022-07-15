package com.yyds.service.impl;
/**
 * @ClassName: HouseServiceImpl
 * @Author: yyd
 * @Date: 2022/5/24
 * @Description:
 */

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyds.base.BaseMapper;
import com.yyds.base.BaseServiceImpl;
import com.yyds.entity.House;
import com.yyds.entity.bo.HouseQueryBo;
import com.yyds.entity.vo.HouseVo;
import com.yyds.mapper.HouseMapper;
import com.yyds.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName: HouseServiceImpl
 * @Author: yyd
 * @Date: 2022/5/24
 * @Description:
 */
@Service(interfaceClass = HouseService.class)
public class HouseServiceImpl extends BaseServiceImpl<House> implements HouseService {
    @Autowired
    private HouseMapper houseMapper;
    @Override
    protected BaseMapper<House> getEntityMapper() {
        return houseMapper;
    }

    @Override
    public void publish(Long id, Integer status) {
        //要发布的房源其实就是修改房源的status的值
        House house = new House();
        //设置房源的status
        house.setStatus(status);
        //设置房源的id
        house.setId(id);
        houseMapper.update(house);
    }


    @Override
    public PageInfo<HouseVo> findListPage(int pageNum, int pageSize, HouseQueryBo houseQueryBo) {
        //开启分页
        PageHelper.startPage(pageNum, pageSize);
        Page<HouseVo> page = houseMapper.findListPage(houseQueryBo);
        return new PageInfo<HouseVo>(page);
    }
}
