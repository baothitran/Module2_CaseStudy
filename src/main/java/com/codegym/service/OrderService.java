package com.codegym.service;

import com.codegym.feature.BannerApp;
import com.codegym.feature.InitApp;
import com.codegym.model.Order;
import com.codegym.model.OrderItem;
import com.codegym.model.Status;
import com.codegym.model.User;
import com.codegym.utils.DateUtils;
import com.codegym.utils.FileUtils;
import com.codegym.view.OrderView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OrderService implements IOrderItemService {
    public static Scanner scanner = new Scanner(System.in);
    public static OrderView orderView = new OrderView();

    OrderItemService orderItemService = new OrderItemService();
    FileUtils fileService;
    public OrderService (){
        fileService = new FileUtils();
    }

    private String filePath = "F:\\BaoThi\\Module2_CaseStudy\\src\\main\\java\\com\\codegym\\data\\order.csv";
    public List<Order> getAllOrderList (){
        List<String> orderLines = fileService.readFile(filePath);
        List<Order> orderList = new ArrayList<>();
        for (String orderline : orderLines){
            String[] orderlines1 = orderline.split(",");
            long id = Long.parseLong(orderlines1[0]);
            long idUser = Long.parseLong(orderlines1[2]);

            double total = Double.parseDouble(orderlines1[6]);
            Status status = Status.findStatusByName(orderlines1[7]);
            Order order = new Order(id, DateUtils.convertStringToDate(orderlines1[1]),total);
            order.setPhoneNumber(orderlines1[4]);
            order.setAddressUser(orderlines1[5]);
            order.setIdUser(idUser);
            order.setNameUser(orderlines1[3]);
            order.setStatus(status);
            List<OrderItem> orderItems = orderItemService.findOrderItemByOrderID(order.getId());
            order.setOrderItem(orderItems);
            orderList.add(order);
        }
        return orderList;
    }

    public void addOrder(Order newOrder){
        List<Order> orderList = getAllOrderList();
        orderList.add(newOrder);
        List<String> orderLines = convertListOrdertoListString(orderList);
        fileService.writeFile(filePath,orderLines);
    }

    public Order getOrderByID (long id, List<Order> orderList){
        for (Order order : orderList){
            if (order.getId()==id){
                return order;
            }
        }
        return null;
    }

    public void saveOrderData (List<Order> orderList){
        List<String> orderLines = convertListOrdertoListString(orderList);
        fileService.writeFile(filePath,orderLines);
    }
    public List<String> convertListOrdertoListString (List<Order> orderList){
        List<String> orderListLines = new ArrayList<>();
        for (Order order : orderList){
            orderListLines.add(order.toData());
        }
        return orderListLines;
    }

    public List<Order> convertListStringtoListOrder (List<String> list){
        List<Order> orderList = new ArrayList<>();
        for (String orderLine : list ){
            String [] orderLines = orderLine.split(",");
            long idOrder = Long.parseLong(orderLines[0]);
            Date date = DateUtils.convertStringToDate(orderLines[1]);
            double total = Double.parseDouble(orderLines[2]);
            Status status = Status.findStatusByName(orderLines[3]);
            Order newOrder = new Order(idOrder,date,total);
            newOrder.setStatus(status);
            orderList.add(newOrder);
        }
        return orderList;
    }

    public List<Order> searchOrderByDate (List<Order> list){
        List<Order> orderList = new ArrayList<>();
        System.out.println("Enter Date (dd-mm-yyyy)");
        String sdate = scanner.nextLine();
        for (Order order : list){
            if (getDataByDate(DateUtils.convertDateToString(order.getDateOrder())).equals(sdate)){
                orderList.add(order);
            }
        }
        return orderList;
    }

    public List<Order> searchOrderByMonth (List<Order> list){
        List<Order> orderList = new ArrayList<>();
        System.out.println("Enter Month (mm)");
        String sMonth = scanner.nextLine();
        for (Order order : list){
            if (getDataByMonth(DateUtils.convertDateToString(order.getDateOrder())).equals(sMonth)){
                orderList.add(order);
            }
        }
        return orderList;
    }
    public String getDataByDate(String date){
        date = date.trim();
        if (date.indexOf(" ")>=0){
            int index = date.lastIndexOf(" ");
            return date.substring(index+1);
        }
        else return date;
    }
    public String getDataByMonth(String month){
        month = month.trim();
        if (month.indexOf(" ")>=0){
            int index = month.lastIndexOf(" ");
            return month.substring(index+4,index+6);
        }
        else return month;
    }
    public List<Order> searchOrderByStatus (List<Order> orderList, String nameStatus){
        List<Order> result = new ArrayList<>();
        for (Order order : orderList){
            String temp = String.valueOf(order.getStatus());
            if (temp.equals(nameStatus)){
                result.add(order);
            }
        }
        return result;
    }

    public void getTotalProfit (List<Order> orderList,User user) throws Exception {
        boolean check;
        do {
            BannerApp.menuBanner("profitMenu");
            check = false;
            List<Order> paidOrderList = searchOrderByStatus(orderList, "Paid");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Nhập ngày bạn mốn xem (dd-mm-yyyy):");
                    double total1 = 0;
                    String day = scanner.nextLine();
                    List<Order> orderList1 = new ArrayList<>();
                    for (Order order : paidOrderList) {
                        if (getDataByDate(DateUtils.convertDateToString(order.getDateOrder())).equals(day)) {
                            total1 += orderView.getTotal(order);
                            orderList1.add(order);
                        }
                    }
                    orderView.printingAllOrders(orderList1,user);
                    System.out.print("■ Tổng:"+ total1 +"\n");
                    check = InitApp.checkContinueActionShowProfit();
                    break;
                case "2":
                    System.out.println("Nhập tháng bạn muốn xem:");
                    double total = 0;
                    String month = scanner.nextLine();
                    List<Order> orderList2 = new ArrayList<>();
                    for (Order order : paidOrderList) {
                        if (getDataByMonth(DateUtils.convertDateToString(order.getDateOrder())).equals(month)) {
                            total += orderView.getTotal(order);
                            orderList2.add(order);
                        }
                    }
                    orderView.printingAllOrders(orderList2,user);
                    System.out.print("■ Tổng:" +total+"\n");
                    check = InitApp.checkContinueActionShowProfit();
                    break;
                case "r":
                    orderView.orderMenuView(user);
                default:
                    System.out.println("Lỗi! Vui lòng nhập lại");
                    check = true;
            }
        }
        while (check);
    }


}