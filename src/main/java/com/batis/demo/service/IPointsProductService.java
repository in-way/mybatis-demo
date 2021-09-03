package com.batis.demo.service;

import com.batis.demo.entity.PointsProduct;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 积分商品表 服务类
 * </p>
 *
 * @author ivy
 * @since 2021-09-02
 */
public interface IPointsProductService extends IService<PointsProduct> {

    List<PointsProduct> mySelectList();

    int add(PointsProduct pointsProduct);

    PointsProduct getOne();
}
