package com.codegym.view;

import com.codegym.feature.BannerApp;

import java.util.Scanner;

public class LoginView {
    public static Scanner scanner = new Scanner(System.in);
    public static LoginAdminView loginAdminView = new LoginAdminView();
    public LoginUserView loginUserView = new LoginUserView();
    public void  login() throws Exception {
        BannerApp.menuBanner("LoginView");
        int choice = Integer.parseInt(scanner.nextLine());
        boolean checkLoginMenu = false;
        do {
            checkLoginMenu = false;
            switch (choice){
                case 1:
                    loginAdminView.loginAdmin();
                    break;
                case 2:
                    loginUserView.loginUser();
                    break;
                case 3:
                    System.exit(5);
                default:
                    System.out.println("Lỗi! Vui lòng nhập lại");
                    checkLoginMenu = true;
            }
        }
        while (checkLoginMenu);
    }



}