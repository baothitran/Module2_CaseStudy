package com.codegym.view;

import com.codegym.feature.BannerApp;
import com.codegym.feature.InitApp;
import com.codegym.feature.SupportApp;
import com.codegym.model.*;
import com.codegym.service.OrderItemService;
import com.codegym.service.OrderService;
import com.codegym.service.ProductService;
import com.codegym.service.UserService;
import com.codegym.utils.DateUtils;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OrderView {
    static Scanner scanner = new Scanner(System.in);
    Order order;
    BannerApp bannerApp = new BannerApp();
    OrderService orderService;
    ProductService productService;
    OrderItemService orderItemService;
    UserService userService;
    Status status;
    static ProductAdminView productAdminView = new ProductAdminView();

    public OrderView() {
        productService = new ProductService();
        orderService = new OrderService();
        orderItemService = new OrderItemService();
        userService = new UserService();
    }

    public void orderMenuView(User user) throws Exception {
        boolean checkOrderView = false;
        do {
            checkOrderView = false;
            bannerApp.menuBanner("OrderView");
            List<Order> orderList = orderService.getAllOrderList();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    showDetailOrderView(orderList);
                    checkOrderView = InitApp.checkContinueActionOrder();
                    break;
                case 2:
                    createOrderView(user);
                    checkOrderView = InitApp.checkContinueActionOrder();
                    break;
                case 3:
                    updateOrderView(orderList,user);
                    checkOrderView = InitApp.checkContinueActionOrder();
                    break;
                case 4:
                    searchOrderByStatusView(orderList,user);
                    checkOrderView = InitApp.checkContinueActionOrder();
                    break;
                case 5:
                    printingAllOrders(orderList,user);
                    checkOrderView = InitApp.checkContinueActionOrder();
                    break;
                case 6:
                    removeOrder(orderList,user);
                    checkOrderView = InitApp.checkContinueActionOrder();
                    break;
                case 7:
                    orderService.getTotalProfit(orderList,user);
                    checkOrderView = InitApp.checkContinueActionOrder();
                    break;
                case 0:
                    System.exit(5);
                case 8:
                    productAdminView.menuAdminView(user);
                default:
                    checkOrderView = true;
                    break;
            }
        }
        while (checkOrderView);
    }

    private void removeOrder(List<Order> list,User user) throws Exception {
        System.out.println("Bạn đang thao tác xoá đơn hàng!!! Y/N ");
        String alert = scanner.nextLine();
        if (alert.toLowerCase().equals("y")) {
            System.out.println("Nhập ID đơn hàng bạn muốn xoá: ");
            long idRemove = Long.parseLong(scanner.nextLine());
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId() == idRemove) {
                    list.remove(i);
                }
            }
            orderService.saveOrderData(list);

        }if (alert.toLowerCase().equals("n")) {
            orderMenuView(user);
        }
        System.out.println("Đã xoá thành công!");
    }


    private void searchOrderByStatusView(List<Order> list,User user) throws Exception {
        boolean checkOrderStatus;
        do {
            checkOrderStatus = false;
            BannerApp.menuBanner("Search-Order-Status-View");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    List<Order> listOrderedResult = orderService.searchOrderByStatus(list, "Pending");
                    System.out.println("                                                   DANH SÁCH ĐƠN HÀNG CHỜ XÁC NHẬN                      ");
                    printingAllOrders(listOrderedResult,user);
                    checkOrderStatus = InitApp.checkContinueSearchOrderStatusMenu();
                    break;
                case "2":
                    List<Order> listOrderedResult2 = orderService.searchOrderByStatus(list, "Paid");
                    System.out.println("                                                   DANH SÁCH ĐƠN HÀNG ĐÃ THANH TOÁN                      ");
                    printingAllOrders(listOrderedResult2,user);
                    checkOrderStatus = InitApp.checkContinueSearchOrderStatusMenu();
                    break;
                case "3":
                    List<Order> listOrderedResult3 = orderService.searchOrderByStatus(list, "NotPaid");
                    System.out.println("                                                   DANH SÁCH ĐƠN HÀNG CHƯA ĐƯỢC THANH TOÁN                      ");
                    printingAllOrders(listOrderedResult3,user);
                    checkOrderStatus = InitApp.checkContinueSearchOrderStatusMenu();
                    break;
                case "4":
                    List<Order> listOrderedResult4 = orderService.searchOrderByStatus(list, "Canceled");
                    System.out.println("                                                   DANH SÁCH ĐƠN HÀNG ĐÃ HUỶ                      ");
                    printingAllOrders(listOrderedResult4,user);
                    checkOrderStatus = InitApp.checkContinueSearchOrderStatusMenu();
                    break;
                case "5":
                    orderMenuView(user);
            }
        }
        while (checkOrderStatus);
    }

    public void printingAllOrders(List<Order> orderList,User user) {
        System.out.printf("%7s %15s %15s %12s %17s %20s %10s %12s", "ID", "Ngày đặt","Tổng","Trạng thái","ID Khách","Tên khách hàng","SĐT","Địa chỉ");
        System.out.println();
        for (Order order : orderList) {
            String temp = String.valueOf(order.getStatus());
            System.out.printf("║%8s║ %16s║ %11s║ %10s║ %21s║ %16s║ %9s║ %12s║",order.getId(), DateUtils.convertDateToString(order.getDateOrder()),
                    getTotal(order),temp,order.getIdUser(),order.getNameUser(),order.getPhoneNumber(),order.getAddressUser());
            System.out.println();
        }
    }



    public void updateOrderView(List<Order> orderList,User user) throws Exception {
        System.out.print("■ Nhập ID đơn hàng:");
        long id = Long.parseLong(scanner.nextLine());
        Order order1 = orderService.getOrderByID(id, orderList);
        if (order1 != null) {
            if (order1.getOrderItem().size() > 0) {
                boolean checkUpdateOrderView;
                do {
                    checkUpdateOrderView = false;
                    bannerApp.menuBanner("Update-Order-View");
                    String choice = scanner.nextLine();
                    switch (choice) {
                        case "1":
                            System.out.print("■ Nhập ngày của đơn hàng bạn muốn cập nhật (dd-mm-yyyy):");
                            String date = scanner.nextLine();
                            order1.setDateOrder(DateUtils.convertStringToDate(date));
                            orderService.saveOrderData(orderList);
                            checkUpdateOrderView = InitApp.checkContinueUpdateOrder();
                            break;
                        case "2":
                            System.out.println("Nhập trạng thái đơn hàng: ");
                            String status = scanner.nextLine();
                            Status choicedStatus = Status.findStatusByName(status);
                            if(choicedStatus != null){
                                order1.setStatus(choicedStatus);
                            }
                            orderService.saveOrderData(orderList);
                            checkUpdateOrderView = InitApp.checkContinueUpdateOrder();
                            break;
                        case "3":
                            orderMenuView(user);
                        default:
                            System.out.println("Lỗi! Vui lòng nhập lại");
                            checkUpdateOrderView = true;
                    }
                }
                while (checkUpdateOrderView);
            } else {
                System.out.println("Size=0");
                productService.printingAllProduct();
                long idProduct = checkIDProduct();
                Product product = productService.findProductByID(idProduct);
                int quantity = checkInputQuantity(order1, idProduct);
                OrderItem orderItem;
                if ((orderItem = checkProductExistinOrder(order1, product.getIdProduct())) != null) {
                    orderItem.setQuantity(quantity + orderItem.getQuantity());
                } else {
                    OrderItem newOrderItem = new OrderItem(System.currentTimeMillis() / 100000, product.getIdProduct(), order1.getId(), quantity, product.getPrice());
                    order1.addOrderItem(newOrderItem);
                }
                order1.setTotal(getTotal(order1));
                showOrderItemsByOrder(order1,user);
                orderItemService.addOrderItem(order1.getOrderItem());
                orderService.saveOrderData(orderList);
            }
        } else System.out.println("Đơn hàng không tồn tại");
    }

    public void createOrderView(User user) {
        order = new Order();
        order.setId(System.currentTimeMillis() / 100000);
        order.setDateOrder(new Date());
        order.setStatus(status.Pending);
        order.setIdUser(user.getID());
//        user.getID();
        boolean checkCreateOrder;
        do {
            checkCreateOrder = true;
            productService.printingAllProduct();
            long idProduct = checkIDProduct();
            Product product = productService.findProductByID(idProduct);
            int quantity = checkInputQuantity(order, idProduct);
            if (quantity == -1) {
                continue;
            }
            OrderItem orderItem;
            if ((orderItem = checkProductExistinOrder(order, product.getIdProduct())) != null) {
                orderItem.setQuantity(quantity + orderItem.getQuantity());
            } else {
                OrderItem newOrderItem = new OrderItem(System.currentTimeMillis() / 1000000, product.getIdProduct(), order.getId(), quantity, product.getPrice());
                order.addOrderItem(newOrderItem);
            }
            showOrderItemsByOrder(order,user);
            checkCreateOrder = InitApp.checkContinueAddOrder();
        }
        while (checkCreateOrder);
        order.setTotal(getTotal(order));
        order.setNameUser(user.getFullname());
        order.setAddressUser(user.getAddress());
        order.setPhoneNumber(user.getMobile());
        orderItemService.addOrderItem(order.getOrderItem());
        orderService.addOrder(order);
    }

    public int checkInputQuantity(Order order, long idProduct) {
        boolean checkInputQuantityAction = false;
        do {
            checkInputQuantityAction = false;
            System.out.print("■ Nhập số lượng:");
            int quantity = Integer.parseInt(scanner.nextLine());
            OrderItem orderItem = checkProductExistinOrder(order, idProduct);
            if (orderItem != null) {
                if (productService.checkRemainQuantityProduct(idProduct, quantity + orderItem.getQuantity())) {
                    return quantity;
                }
            } else {
                if (productService.checkRemainQuantityProduct(idProduct, quantity)) {
                    return quantity;
                }
            }
            Product product = productService.findProductByID(idProduct);
            System.out.printf("Store is: %d. Your order is run out of store", product.getQuantity());
            checkInputQuantityAction = InitApp.checkContinueActionMenu();
        }
        while (checkInputQuantityAction);
        return -1;
    }

    public long checkIDProduct() {
        boolean checkidproduct;
        do {
            checkidproduct = false;
            System.out.print("■ Nhập ID sản phẩm:");
            long id = Long.parseLong(scanner.nextLine());
            int flag = 0;
            for (Product product : productService.getAllProducts()) {
                if (product.getIdProduct() == id) {
                    return id;
                } else {
                    flag = -1;
                }
            }
            if (flag == -1) {
                System.out.println("Lỗi! Vui lòng nhập lại");
                checkidproduct = true;
            }
        }
        while (checkidproduct);
        return -1;
    }

    public OrderItem checkProductExistinOrder(Order order, long idProduct) {
        for (OrderItem orderItem : order.getOrderItem()) {
            if (orderItem.getIdProduct() == idProduct) {
                return orderItem;
            }
        }
        return null;
    }

    public void showDetailOrderView(List<Order> orderList) {
        System.out.println("Nhập ID đơn hàng:");
        long idFindedOrder = Integer.parseInt(scanner.nextLine());
        Order findedOrder = orderService.getOrderByID(idFindedOrder, orderList);
        showDetailOrderViewByID(findedOrder);
    }

    public void showDetailOrderViewByID(Order order) {
        System.out.println("╔════════════════════════════════════════════HOÁ ĐƠN═════════════════════════════════════════════════════╗");
        System.out.println("\t" + "\t" + "ID Đơn hàng: " + order.getId() + "\t" + "Được tạo:" + DateUtils.convertDateToString(order.getDateOrder())+ "\t" +"Khách hàng: " +order.getNameUser());
        for (OrderItem orderItem : order.getOrderItem()) {
            Product product = productService.findProductByID(orderItem.getIdProduct());
            System.out.println(
                    String.format("\t \t \t \t %-20s|%-15s|%-10s|%-10s", product.getNameProduct(), orderItem.getPrice(), orderItem.getQuantity(), orderItem.getQuantity() * orderItem.getPrice())
            );
        }
        System.out.println("                        \t \t \t \t\t \t \tTổng: " + getTotal(order));
        System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }

    public void showOrderItemsByOrder(Order order,User user) {
        System.out.println("╔═════════════════════════════════════════SẢN PHẨM ĐƯỢC ĐẶT MUA═══════════════════════════════════════════╗");
        System.out.println("          Khách hàng: "+user.getFullname()+"\tĐiện thoại:"+user.getMobile()+"\tĐịa chỉ: "+user.getAddress());
        for (OrderItem orderItem : order.getOrderItem()) {
            Product product = productService.findProductByID(orderItem.getIdProduct());
            System.out.println(String.format("\t \t \t \t %-20s|%-15s|%-10s|%-10s", product.getNameProduct(), orderItem.getPrice(), orderItem.getQuantity(), orderItem.getQuantity() * orderItem.getPrice()));
        }
        System.out.println("                        \t \t \t \t\t \t \tTổng: " + getTotal(order));
        System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }

    public long getTotal(Order order) {
        long total = 0;
        for (OrderItem orderItem : order.getOrderItem()) {
            total += orderItem.getPrice() * orderItem.getQuantity();
        }
        return total;
    }



}