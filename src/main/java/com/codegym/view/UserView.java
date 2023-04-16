package com.codegym.view;

import com.codegym.feature.BannerApp;
import com.codegym.model.Product;
import com.codegym.model.User;
import com.codegym.service.OrderService;
import com.codegym.service.ProductService;
import com.codegym.service.UserService;

import java.util.List;
import java.util.Scanner;

public class UserView {
    static Scanner scanner = new Scanner(System.in);
    static ProductView productView = new ProductView();
    ProductService productService = new ProductService();
    OrderService orderService = new OrderService();
    OrderView orderView = new OrderView();
    UserService userService = new UserService();
    public void menuUser(User user) {
        try {
            BannerApp.menuBanner("userView");
            int choice;
            do {
                List<Product> products;
                products = productService.getAllProducts();
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        productView.showProductView(products);
                        menuUser(user);
                        break;
                    case 2:
                        orderView.createOrderView(user);
                        menuUser(user);
                        break;
                    case 3:
                        productView.sortProductView(products, user);
                        menuUser(user);
                        break;
                    case 4:
                        productView.searchProductView(user);
                        menuUser(user);
                        break;
                    case 0:
                        System.exit(5);
                }

            } while (choice != 0);
        } catch (Exception e) {
            System.out.println("Lỗi! Vui lòng nhập lại");
        }
    }

}