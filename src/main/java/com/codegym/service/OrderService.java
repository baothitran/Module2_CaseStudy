package com.codegym.service;

import com.codegym.model.Order;
import com.codegym.utils.FileUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderService implements IOrderService{
    private final static String PATHORDER = "F:\\Test3\\CaseStudy_m2\\CaseStudy\\data\\orders.csv";
    private static OrderService instance;

    public OrderService() {}

    public static OrderService getInstance() {
        if(instance == null)
            instance = new OrderService();
        return instance;
    }
    @Override
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        List<String> records = FileUtils.read(PATHORDER);
        for (String record: records) {
            orders.add(Order.parseOrder(record));
        }
        return orders;
    }

    @Override
    public void add(Order newOrder) {
        List<Order> orders = findAll();
        newOrder.setCreatedAt(Instant.now());
        orders.add(newOrder);
        FileUtils.write(PATHORDER, orders);
    }

    @Override
    public void update() {
        List<Order> orders = findAll();
        FileUtils.write(PATHORDER, orders);
    }

    @Override
    public Order findById(long id) {
        List<Order> orders = findAll();
        for (Order order: orders) {
            if (order.getId() == id)
                return order;
        }
        return null;
    }

    @Override
    public List<Order> findByUserId(long id) {
        List<Order> newOrder = new ArrayList<>();
        for (Order order: findAll()) {
            if (order.getId() == id)
                newOrder.add(order);
        }
        return null;
    }

    @Override
    public boolean existById(long id) {
        return findById(id) != null;
    }
}