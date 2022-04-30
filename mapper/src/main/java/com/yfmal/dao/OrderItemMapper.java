package com.yfmal.dao;

import com.yfmal.entity.OrderItem;
import genetator.GeneralDAO;

import java.util.List;

public interface OrderItemMapper extends GeneralDAO<OrderItem> {

    public List<OrderItem> listOrderItemsByOrderId(String orderId);

}