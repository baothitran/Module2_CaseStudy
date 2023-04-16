package com.codegym.service;

import com.codegym.model.Order;
import com.codegym.model.User;

import java.util.List;

public interface IOrderService {
    List<Order> getAllOrderList ();
    void addOrder(Order newOrder);
    Order getOrderByID (long id, List<Order> orderList);
    void saveOrderData (List<Order> orderList);
    String getDataByDate(String date);
    List<Order> searchOrderByStatus (List<Order> orderList, String nameStatus);

}
