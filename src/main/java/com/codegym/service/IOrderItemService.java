package com.codegym.service;

import com.codegym.model.OrderItem;

import java.util.List;

public interface IOrderItemService {
    List<OrderItem> getAllOrderItems ();
    void addOrderItem (List<OrderItem> orderItem);
    List<String> converListOrderItemToListString (List <OrderItem> list);
    List<OrderItem> findOrderItemByOrderID (long id);


}
