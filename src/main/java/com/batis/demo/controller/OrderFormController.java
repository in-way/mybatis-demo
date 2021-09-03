package com.batis.demo.controller;


import com.batis.demo.entity.OrderForm;
import com.batis.demo.service.IOrderFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 订单主表 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-09-01
 */
@RestController
@RequestMapping("/test/order-form")
public class OrderFormController {
    @Autowired
    IOrderFormService orderFormService;
    @RequestMapping("/test")
    public List<OrderForm> test(){
        List<OrderForm> list = orderFormService.test(101170613000003L);
        return list;
    }
    @RequestMapping("/test1")
    public List<OrderForm> test1(){
        OrderForm orderForm = new OrderForm();
        orderForm.setOrderNo(101170613000003L);
        List<OrderForm> list = orderFormService.findList(orderForm);
        return list;
    }
    @RequestMapping("/test2")
    public OrderForm test2(){
        OrderForm orderForm = orderFormService.test1();
        return orderForm;
    }
}
