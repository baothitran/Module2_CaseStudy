package com.codegym.view;

import com.codegym.feature.BannerApp;
import com.codegym.feature.InitApp;
import com.codegym.model.User;
import com.codegym.service.UserService;

import java.util.Scanner;

public class LoginAdminView {
    static LoginView loginView = new LoginView();

    public  static Scanner scanner = new Scanner(System.in);
    UserService userService = new UserService();
    ProductAdminView productAdminView = new ProductAdminView();
    public void loginAdmin () throws Exception {

        Boolean checkLoginAdmin = false;
        do {
            checkLoginAdmin = false;
            System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                           ĐĂNG NHẬP                                                      ");
            System.out.println("                                       【1】. Tên tài khoản                                                ");
            System.out.println("                                       【2】. Mật khẩu                                                ");
            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("Nhập tên tài khoản:");
            String username = InitApp.isNotEmpty();
            System.out.println("Nhập mật khẩu:");
            String password = InitApp.isNotEmpty();
            if (userService.adminLogin(username, password) != null) {
                User admin = userService.adminLogin(username, password);
                BannerApp.menuBanner("Access-Success");
                productAdminView.menuAdminView(admin);
                checkLoginAdmin = false;
            }
            else {
                System.out.println("Tài khoản không đúng! Vui lòng nhập lại");
                checkLoginAdmin = retryLogin();
            }
        }
        while (checkLoginAdmin);
    }

    public static boolean retryLogin () throws Exception {
        do {
            System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                                               【1】. Đăng nhập lại                                                 ║");
            System.out.println("║                                               【2】. Trở về                                                      ║");
            System.out.println("║                                               【0】. Thoát                                                        ║");
            System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
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
                    System.out.println("Lỗi! Vui lòng nhập lại");
                    break;
            }
        }
        while (true);
    }

}