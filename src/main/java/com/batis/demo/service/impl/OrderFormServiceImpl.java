package com.batis.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.batis.demo.entity.OrderForm;
import com.batis.demo.mapper.OrderFormMapper;
import com.batis.demo.service.IOrderFormService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 订单主表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-09-01
 */
@Service
public class OrderFormServiceImpl extends ServiceImpl<OrderFormMapper, OrderForm> implements IOrderFormService {
    @Autowired
    OrderFormMapper orderFormMapper;
    @Override
    public List<OrderForm> test(Long id){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("ORDER_NO",id);
        List list = orderFormMapper.selectList(queryWrapper);
        return list;
    }
    @Override
    public List<OrderForm> findList(OrderForm orderForm){
        return orderFormMapper.findList(orderForm);
    }

    @Override
    public OrderForm test1() {
        OrderForm orderForm = orderFormMapper.selectById(101170613000003L);
        return orderForm;
    }
}
