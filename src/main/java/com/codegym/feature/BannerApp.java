package com.codegym.feature;

public class BannerApp {
    public static void menuBanner(String option) {
        if (option.equals("Product-ViewMenu")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                         WELCOME PRODUCT MENU                                            ");
            System.out.println("                    【1】ADD PRODUCT                         【4】SEARCH PRODUCT                           ");
            System.out.println("                    【2】EDIT PRODUCT                        【5】SORT PRODUCT                             ");
            System.out.println("                    【3】REMOVE PRODUCT                      【6】PRINTING LIST PRODUCT                    ");
            System.out.println("                    【0】EXIT                                【R】Return AdminView                         ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("■ Select:");
        }
        if (option.equals("Sort-Product-Menu")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                SORTING PRODUCT                                                     ");
            System.out.println("                         【1】SORTING PRODUCT BY PRICE                                           ");
            System.out.println("                         【R】Return                                                  ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("■ Select:");
        }
        if (option.equals("Searching-Product")) {
            System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                                SEARCHING PRODUCT                                                     ");
            System.out.println("                         【1】SEARCHING PRODUCT BY ID             【2】SEARCHING PRODUCT BY NAME                              ");
            System.out.println("                         【R】Return                                                                                   ");
            System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("■ Select:");
        }
        if (option.equals("Product-Service")) {
            System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                                ADD PRODUCT MENU                                                 ");
            System.out.println("                         【1】ADD NAME PRODUCT                        【3】ADD QUANTITY PRODUCT                    ");
            System.out.println("                         【2】ADD PRICE PRODUCT                       【4】ADD ID CATEGORY                         ");
            System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("■ Select:");
        }
        if (option.equals("Update-product")) {
            System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                                EDIT PRODUCT MENU                                                     ");
            System.out.println("                         【1】EDIT NAME PRODUCT                          【3】EDIT PRICE PRODUCT                              ");
            System.out.println("                         【2】EDIT QUANTITY PRODUCT                      【R】RETURN                                  ");
            System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("■ Select:");
        }
        if (option.equals("Sort-by-price")) {
            System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                                SORTING PRODUCT BY PRICE                                                    ");
            System.out.println("                         【1】Increasing                          【2】Decreasing                   ");
            System.out.println("                         【R】Return                                                         ");
            System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("■ Select:");
        }
        if (option.equals("OrderView")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                     ORDER MENU VIEW                                        ");
            System.out.println("                    【1】Show detail Order                  【2】Add new Order         ");
            System.out.println("                    【3】Update Order                       【4】Search Order By Status  ");
            System.out.println("                    【5】Search Order By Duration Time      【6】Show all order                ");
            System.out.println("                    【7】Remove Order                       【8】Show Profit");
            System.out.println("                    【0】EXIT                               【R】Return");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("■ Select:");
        }
        if (option.equals("Update-Order-View")) {
            System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                                UPDATE ORDER VIEW                                                    ");
            System.out.println("                         【1】Update date order                                【2】Update OrderItem                   ");
            System.out.println("                         【3】Update Status Order                              【R】Return Menu Order                 ");
            System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("■ Select:");
        }
        if (option.equals("Search-Order-Status-View")) {
            System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                        SEARCH ORDER BY STATUS VIEW                                                    ");
            System.out.println("                         【1】Pending                                 【2】Processing                   ");
            System.out.println("                         【3】Paid                                    【4】NotPaid                   ");
            System.out.println("                         【5】Canceled                                【R】Return Menu Order                   ");
            System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("■ Select:");
        }
        if (option.equals("Search-Order-ByDurationTime")){
            System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                         SEARCH ORDER BY DURATION TIME                                                    ");
            System.out.println("                  【1】Search order by day                              【2】Search order by month                   ");
            System.out.println("                  【R】Return order menu view                                               ");
            System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("■ Select:");
        }
        if (option.equals("LoginView")){
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                           WELCOME LOGIN MENU                                         ");
            System.out.println("                                        【1】LOGIN ADMIN ACCOUNT                                    ");
            System.out.println("                                        【2】LOGIN USER ACCOUNT                                         ");
            System.out.println("                                        【3】EXIT                                                   ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Select:");
        }
        if (option.equals("Admin-Menu-View")) {
            System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
            System.out.println("╔═════════════════════════════════════════════════════════════════╗");
            System.out.println("                          WELCOME ADMIN MENU                          ");
            System.out.println("                         【1】MANAGE PRODUCT                                        ");
            System.out.println("                         【2】MANAGE ORDER                                       ");
            System.out.println("                         【3】MANAGE USER                                     ");
            System.out.println("          【0】EXIT                     【R】Return Login View ");
            System.out.println("╚═════════════════════════════════════════════════════════════════╝");
            System.out.println("■ Select:");
        }
        if (option.equals("set-role")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                       SET ROLE USER                                         ");
            System.out.println("                                        【1】USER                                   ");
            System.out.println("                                        【2】ADMIN                                         ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("■ Select:");
        }
        if (option.equals("List-User")) {
            System.out.println("╔═════════════════════════════════════════════════════════════════╗");
            System.out.println("                            LIST OF USER                                ");
            System.out.println("                         【1】SHOW ALL USER                                        ");
            System.out.println("                         【2】ADD USER                                       ");
            System.out.println("                         【3】UPDATE USER                                     ");
            System.out.println("                         【4】REMOVE USER                                       ");
            System.out.println("                         【5】RETURN MENU                                    ");
            System.out.println("                         【0】EXIT "                              );
            System.out.println("╚═════════════════════════════════════════════════════════════════╝");
            System.out.println("■ Select:");
        }
        if (option.equals("Update-UserView")) {
            System.out.println("╔═════════════════════════════════════════════════════════════════╗");
            System.out.println("                            UPDATE USER                     ");
            System.out.println("                         【1】UPDATE NAME                                        ");
            System.out.println("                         【2】UPDATE PHONENUMBER                                       ");
            System.out.println("                         【3】UPDATE ADDRESS                                     ");
            System.out.println("                         【4】UPDATE EMAIL                                       ");
            System.out.println("                         【5】UPDATE ALL USER                                    ");
            System.out.println("                         【6】RETURN MENU                                    ");
            System.out.println("                         【0】EXIT        ");
            System.out.println("╚═════════════════════════════════════════════════════════════════╝");
            System.out.println("■ Select:");
        }
        if (option.equals("userView")) {
            System.out.println("╔═════════════════════════════════════════════════════════════════╗");
            System.out.println("                            PROFILE PAGE                ");
            System.out.println("        【1】SHOW ALL PRODUCT               【3】SORT PRODUCT                    ");
            System.out.println("        【2】CREATE ORDER                   【4】SEARCH PRODUCT                   ");
            System.out.println("        【0】EXIT                                 ");
            System.out.println("╚═════════════════════════════════════════════════════════════════╝");
            System.out.println("■ Select:");
        }
        if (option.equals("profitMenu")) {
            System.out.println("╔═════════════════════════════════════════════════════════════════╗");
            System.out.println("                            SHOW PROFIT                     ");
            System.out.println("   【1】SHOW PROFIT BY DAY               【2】SHOW PROFIT BY MONTH                    ");
            System.out.println("                            【R】Return                                           " );
            System.out.println("╚═════════════════════════════════════════════════════════════════╝");
            System.out.println("■ Select:");
        }
    }


}