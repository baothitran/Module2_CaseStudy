package com.codegym.service;

import com.codegym.model.Order;
import com.codegym.model.OrderItem;
import com.codegym.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderItemService implements IOrderItemService {
    FileUtils fileService;
    Order order = new Order();
    private final String filePath = "F:\\BaoThi\\Module2_CaseStudy\\src\\main\\java\\com\\codegym\\data\\orderitem.csv";
    public OrderItemService(){
        fileService = new FileUtils();
    }
    public List<OrderItem> getAllOrderItems (){
        List<String> orderItemsLines = fileService.readFile(filePath);
        List<OrderItem> orderItems = new ArrayList<>();
        for (String line : orderItemsLines ){
            String [] lines = line.split(",");
            long id = Long.parseLong(lines[0]);
            long idProduct = Long.parseLong(lines[1]);
            long idOrder = Long.parseLong(lines[2]);
            int quantity = Integer.parseInt(lines[3]);
            double price = Double.parseDouble(lines[4]);
            OrderItem orderItem = new OrderItem(id,idProduct,idOrder,quantity,price);
            orderItems.add(orderItem);
        }
        return orderItems;
    }
//
//    public OrderItem findOrderItemIDbyIDProduct (long id){
//        List<OrderItem> orderItems = getAllOrderItems();
//        for (OrderItem orderItem : orderItems){
//            if (orderItem.getIdProduct()==id){
//                return orderItem;
//            }
//        }
//        return null;
//    }

    public void addOrderItem (List<OrderItem> orderItem){
        List<OrderItem> orderItems = getAllOrderItems();
        orderItems.addAll(orderItem);
        List<String> orderItemsLines = converListOrderItemToListString(orderItems);
        fileService.writeFile(filePath,orderItemsLines);
    }

    public List<String> converListOrderItemToListString (List <OrderItem> list){
        List<String> orderItemsLines = new ArrayList<>();
        for (OrderItem orderItem : list){
            orderItemsLines.add(orderItem.toData());
        }
        return orderItemsLines;
    }

    public List<OrderItem> findOrderItemByOrderID (long id){
        List<OrderItem> orderItems = getAllOrderItems();
        List<OrderItem> orderItemsResult = new ArrayList<>();
        for (OrderItem orderItem : orderItems){
            if (orderItem.getIdOrder()==id){
                orderItemsResult.add(orderItem);
            }
        }
        return orderItemsResult;
    }
//
//    public OrderItem findOrderItemByID(long id,List<OrderItem> orderItems) {
//        for (OrderItem orderItem : orderItems){
//            if (orderItem.getId()==id){
//                return orderItem;
//            }
//        }
//        return null;
//    }
//
//    public void saveOrderItemData (List<OrderItem> orderItems){
//        List<String> orderItemLines = converListOrderItemToListString(orderItems);
//        fileService.writeFile(filePath,orderItemLines);
//    }
//
//    public void showOrderItem (Order order){
//        for (OrderItem orderItem : order.getOrderItem()){
//            System.out.println(orderItem);
//        }
//    }

}