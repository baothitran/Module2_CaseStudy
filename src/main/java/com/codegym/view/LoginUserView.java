package com.codegym.view;

import com.codegym.feature.BannerApp;
import com.codegym.feature.InitApp;
import com.codegym.model.User;
import com.codegym.service.UserService;

import java.util.Scanner;

public class LoginUserView {
    public static Scanner scanner = new Scanner(System.in);
    static UserService userService = new UserService();
    ProductView productView = new ProductView();
    static UserView userView = new UserView();
    public static LoginView loginView = new LoginView();
    public static String name;
    public void loginUser() throws Exception {
        Boolean checkLoginAdmin = false;
        do {
            checkLoginAdmin = false;
            System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                           LOGIN USER                                                      ");
            System.out.println("                                       【1】. ENTER USERNAME                                                ");
            System.out.println("                                       【2】. ENTER PASSWORD                                                ");
            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("Enter Username:");
            LoginUserView.name  = InitApp.isNotEmpty();
            System.out.println("Enter Password:");
            String password = InitApp.isNotEmpty();
            if (userService.userLogin(name, password) != null) {
                BannerApp.menuBanner("Access-Success");
                User user = userService.userLogin(name, password);
                userView.menuUser(user);
                checkLoginAdmin = false;
            }
            else {
                System.out.println("Your account is NOT MATCH. Please type again!");
                checkLoginAdmin = retryLogin();
            }
        }
        while (checkLoginAdmin);
    }

    public static boolean retryLogin () throws Exception {
        do {
            System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                                               【1】. LOGIN USER                                                 ║");
            System.out.println("║                                               【2】. RETURN                                                      ║");
            System.out.println("║                                               【0】. EXIT                                                        ║");
            System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.print("■ Select:");
            int choiceRetryLogin = Integer.parseInt(scanner.nextLine());
            switch (choiceRetryLogin){
                case 1:
                    return true;
                case 2:
                    loginView.login();
                    break;
                case 0:
                    System.exit(5);
                default:
                    System.out.println("Error value! Please type again");
            }
        }
        while (true);
    }
}
