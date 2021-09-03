package com.batis.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.batis.demo.entity.PointsProduct;
import com.batis.demo.mapper.PointsProductMapper;
import com.batis.demo.service.IPointsProductService;
import com.batis.demo.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 积分商品表 服务实现类
 * </p>
 *
 * @author ivy
 * @since 2021-09-02
 */
@Service
public class PointsProductServiceImpl extends BaseServiceImpl<PointsProductMapper, PointsProduct> implements IPointsProductService {

    @Override
    public List<PointsProduct> mySelectList(){
        QueryWrapper<Object> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.ne("POINTS_PRODUCT_ID",20);
        List list = selectList(objectQueryWrapper);
        return list;
    }

    @Override
    public int add(PointsProduct pointsProduct) {
        return insert(pointsProduct);
    }

    @Override
    public PointsProduct getOne() {
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("POINTS_PRODUCT_ID",1);
        return getOne(wrapper);
    }

}
