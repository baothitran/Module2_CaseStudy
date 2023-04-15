package com.codegym.model;

import com.codegym.utils.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private String nameUser;
    private long idUser;
    private String addressUser;
    private String phoneNumber;

    public String getAddressUser() {
        return addressUser;
    }

    public void setAddressUser(String addressUser) {
        this.addressUser = addressUser;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    private long id;
    private Date dateOrder;
    private double total;
    private List<OrderItem> orderItems;

    private Status status;

    public Order() {
        orderItems = new ArrayList<>();
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public Order(long id, Date dateOrder, double total) {
        this.id = id;
        this.dateOrder = dateOrder;
        this.total = total;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<OrderItem> getOrderItem() {
        return orderItems;
    }

    public void setOrderItem(List<OrderItem> orderItem) {
        this.orderItems = orderItem;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String toData() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", this.id, DateUtils.convertDateToString(this.dateOrder),this.idUser,this.nameUser
                ,this.getPhoneNumber(),this.getAddressUser(),this.total, this.status);
    }

    @Override
    public String toString() {
        String temp = String.valueOf(this.getStatus());
        return String.format("║%10s║ %20s║ %15s║ %10s║ %10s║", this.id, DateUtils.convertDateToString(this.getDateOrder()), getTotal(), temp, this.orderItems);
    }
}
