package com.codegym.feature;

import java.util.Scanner;

public class InitApp {
    public  static Scanner scanner = new Scanner(System.in);
    public static String isNotEmpty (){
        String value = scanner.nextLine();
        while (value.isEmpty()){
            System.out.println("Tên tài khoản không được để trống! Vui lòng nhập lại");
        }
        return value;
    }
    public static boolean checkContinueActionMenu() {
        System.out.println("Bạn có muốn tiếp tục không? Y/N");
        String choiceContinueAction = scanner.nextLine().trim().toUpperCase();;
        switch (choiceContinueAction){
            case "Y":
                return true;
            case "N":
                return false;
            default:
                System.out.println("Lỗi! Vui lòng nhập lại");
                return true;
        }
    }

    public static boolean checkContinueActionOrder (){
        System.out.println("Bạn có muốn tếp tục thao tác với trang Đặt hàng không? Y/N");
        String choiceContinueActionOrder = scanner.nextLine().trim().toUpperCase();;
        switch (choiceContinueActionOrder){
            case "Y":
                return true;
            case "N":
                return false;
            default:
                System.out.println("Lỗi! Vui lòng nhập lại");
                return true;
        }
    }

    public static boolean checkContinueUpdateOrder (){
        System.out.println("Bạn có muốn tiếp tục chỉnh sửa không? Y/N");
        String choiceContinueActionOrder = scanner.nextLine().trim().toUpperCase();;
        switch (choiceContinueActionOrder){
            case "Y":
                return true;
            case "N":
                return false;
            default:
                System.out.println("Lỗi! Vui lòng nhập lại");
                return true;
        }
    }

    public static boolean checkContinueAddProduct() {
        System.out.println("Bạn có muốn tiếp tục thêm sản phẩm không? Y/N");
        String choiceContinueAction = scanner.nextLine().trim().toUpperCase();;
        switch (choiceContinueAction){
            case "Y":
                return true;
            case "N":
                return false;
            default:
                System.out.println("Lỗi! Vui lòng nhập lại");
                return true;
        }
    }

    public static boolean checkContinueRemoveUser() {
        System.out.println("Bạn có muốn tiếp tục xoá khách hàng không? Y/N");
        String choiceContinueAction = scanner.nextLine().trim().toUpperCase();;
        switch (choiceContinueAction){
            case "Y":
                return true;
            case "N":
                return false;
            default:
                System.out.println("Lỗi! Vui lòng nhập lại");
                return true;
        }
    }
    public static boolean checkContinueAddOrder() {
        System.out.println("Bạn có muốn tếp tục thêm đơn hàng không? Y/N");
        String choiceContinueAction = scanner.nextLine().trim().toUpperCase();;
        switch (choiceContinueAction){
            case "Y":
                return true;
            case "N":
                return false;
            default:
                System.out.println("Lỗi! Vui lòng nhập lại");
                return true;
        }
    }

    public static boolean checkContinueWatchPage (){
        System.out.println("Do you want to continue watch page: 【Yes】(Y) or 【No】(N)");
        String choicecontinueAction = scanner.nextLine().trim().toUpperCase();;
        switch (choicecontinueAction){
            case "Y":
                return true;
            case "N":
                return false;
            default:
                System.out.println("Error Value. Please Type again");
                return true;
        }
    }

    public static boolean checkContinueUpdateMenu (){
        System.out.println("Bạn có muốn tiếp tục chỉnh sửa không? Y/N");
        String choicecontinueAction = scanner.nextLine().trim().toUpperCase();;
        switch (choicecontinueAction){
            case "Y":
                return true;
            case "N":
                return false;
            default:
                System.out.println("Lỗi! Vui lòng nhập lại");
                return true;
        }
    }
    public static boolean checkContinueSearchOrderStatusMenu (){
        System.out.println("Bạn có muốn tiê tục tra cứu đơn hàng không? Y/N");
        String choice = scanner.nextLine().trim().toUpperCase();;
        switch (choice){
            case "Y":
                return true;
            case "N":
                return false;
            default:
                System.out.println("Lỗi! Vui lòng nhập lại");
                return true;
        }
    }

    public static boolean checkContinueActionShowProfit (){
        System.out.println("Bạn có muốn tiếp tục xem doanh thu không? Y/N");
        String choice = scanner.nextLine().trim().toUpperCase();;
        switch (choice){
            case "Y":
                return true;
            case "N":
                return false;
            default:
                System.out.println("Lỗi! Vui lòng nhập lại");
                return true;
        }
    }

}