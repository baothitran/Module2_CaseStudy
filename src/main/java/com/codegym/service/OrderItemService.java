package com.codegym.service;

import com.codegym.model.OrderItem;
import com.codegym.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderItemService implements IOrderItemService{
    private final static String PATH = "F:\\Test3\\CaseStudy_m2\\CaseStudy\\data\\order-items.csv";
    private static OrderItemService instance;

    private OrderItemService() {
    }

    public static OrderItemService getInstance() {
        if (instance == null)
            instance = new OrderItemService();
        return instance;
    }

    // tra ve list OrderItem
    @Override
    public List<OrderItem> findAll() {
        List<OrderItem> orderItems = new ArrayList<>();
        List<String> records = FileUtils.read(PATH);
        for (String record : records) {
            orderItems.add(OrderItem.parseOrderItem(record));
        }
        return orderItems;
    }


    @Override
    public void add(OrderItem newOrderItem) {
        List<OrderItem> orderItems = findAll();
        orderItems.add(newOrderItem);
        FileUtils.write(PATH, orderItems);
    }

    @Override
    public void update(long orderId, double price, double sum) {
        List<OrderItem> orderItems = findAll();
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getOrderId() == orderId) {
                if (orderItem.getPrice() == price) {
                    orderItem.setGrandTotal(sum);
                    FileUtils.write(PATH, orderItems);
                    break;
                }
            }
        }
    }

    @Override
    public OrderItem getOrderItemById(int id) {
        List<OrderItem> orderItems = findAll();
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getId() == id)
                return orderItem;
        }
        return null;
    }
}