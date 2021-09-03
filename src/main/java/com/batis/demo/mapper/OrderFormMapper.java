package com.batis.demo.mapper;

import com.batis.demo.entity.OrderForm;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 订单主表 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2021-09-01
 */
@Mapper
public interface OrderFormMapper extends BaseMapper<OrderForm> {
    List<OrderForm> findList(OrderForm record);
}
