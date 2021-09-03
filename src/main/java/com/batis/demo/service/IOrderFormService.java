package com.batis.demo.service;

import com.batis.demo.entity.OrderForm;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 订单主表 服务类
 * </p>
 *
 * @author jobob
 * @since 2021-09-01
 */
public interface IOrderFormService extends IService<OrderForm> {
    List<OrderForm> test(Long id);

    List<OrderForm> findList(OrderForm orderForm);

    OrderForm test1();
}
