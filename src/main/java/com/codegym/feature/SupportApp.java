package com.codegym.feature;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class SupportApp {
    static Scanner scanner = new Scanner(System.in);

    public static String retryString() {
        String result;
        while ((result = scanner.nextLine()).isEmpty()) {
            System.out.printf("Không được để trống \n");
            System.out.print("Mời nhập lại: ");
        }
        return result;
    }

    public static int retryChoose(int min, int max) {
        int option;
        do {
            try {
                option = Integer.parseInt(scanner.nextLine());
                if (option > max || option < min) {
                    System.out.println("Nhập sai ! Vui lòng nhập từ " + min + " đến " + max );
                    continue;
                }
                break;
            } catch (Exception ex) {
                System.out.println("Lỗi! Vui lòng nhập lại:  ");
            }
        } while (true);
        return option;
    }

    public static String formatNumber(double a) {
        String result;
        Locale locale = new Locale("eu", "EU");
        NumberFormat numberFormat = NumberFormat.getInstance(locale);
        return result = numberFormat.format(a);
    }

}
