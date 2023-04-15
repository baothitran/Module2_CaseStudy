package com.codegym.view;

import com.codegym.feature.BannerApp;
import com.codegym.feature.InitApp;
import com.codegym.feature.SupportApp;
import com.codegym.model.Role;
import com.codegym.model.User;
import com.codegym.service.UserService;
import com.codegym.utils.DateUtils;
import com.codegym.utils.FileUtils;
import com.codegym.utils.ValidateUtils;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ManagerUserView {
    FileUtils fileService = new FileUtils();
    public static Scanner scanner = new Scanner(System.in);
    private final UserService userService;
    public static ProductView productView = new ProductView();
    public static ProductAdminView productAdminView = new ProductAdminView();

    public ManagerUserView() {
        userService = UserService.getUserService();
    }

    public void menuUser(User user) throws Exception {
        int number;
        System.out.println("");
        BannerApp.menuBanner("List-User");
        do {

            number = Integer.parseInt(scanner.nextLine());
            List<User> userList = userService.showUserView();
            switch (number) {
                case 1:
                    showAllUser();
                    menuUser(user);
                    break;
                case 2:
                    addUserView(userList);
                    menuUser(user);
                    break;
                case 3:
                    updateUser(user);
                    menuUser(user);
                    break;
                case 4:
                    removeUser(user);
                    menuUser(user);
                    break;
                case 5:
                    productAdminView.menuAdminView(user);
                    break;
                case 0:
                    System.exit(5);
                    break;
            }
        } while (number != 0);
    }

    public void removeUser(User user) throws Exception {
        boolean checkRemoveAction;
        do {
            checkRemoveAction = false;
            showAllUser();
            System.out.println("Enter ID User you want to remove");
            Long idUserDel = inputId(user);
            userService.removeUser(idUserDel,user);
            checkRemoveAction = InitApp.checkContinueRemoveUser();
        } while (checkRemoveAction);
    }

    public void updateUser(User user) {
        boolean isRetry = false;
        do {
            try {
                showAllUser();
                System.out.println("Enter ID User you want to update");
                Long id = inputId(user);
                BannerApp.menuBanner("Update-UserView");
                int option = SupportApp.retryChoose(0, 7);
                User newUser = new User();
                newUser.setID(id);
                String name;
                String phone;
                String address;
                String email;
                switch (option) {
                    case 1:
                        name = inputFullName();
                        newUser.setFullname(name);
                        userService.update(newUser);
                        break;
                    case 2:
                        phone = inputPhone();
                        newUser.setMobile(phone);
                        userService.update(newUser);
                        break;
                    case 3:
                        address = inputAddress();
                        newUser.setAddress(address);
                        userService.update(newUser);
                        break;
                    case 4:
                        email = inputEmail();
                        newUser.setEmail(email);
                        userService.update(newUser);
                        break;
                    case 5:
                        name = inputFullName();
                        newUser.setFullname(name);
                        phone = inputPhone();
                        newUser.setMobile(phone);
                        address = inputAddress();
                        newUser.setAddress(address);
                        email = inputEmail();
                        newUser.setEmail(email);
                        userService.update(newUser);
                }
                isRetry = option != 5 && isRetry;

            } catch (Exception e) {
                System.out.println("Error! Type again");
            }
        } while (isRetry);
    }

    public void addUserView(List<User> users) {
        try {
            User user = new User();
            Long id = System.currentTimeMillis() / 1000;
            String username = inputUsername();
            String password = inputPassword("");
            String fullName = inputFullName();
            String phone = inputPhone();
            String address = inputAddress();
            String email = inputEmail();
            user.setID(id);
            user.setAccount(username);
            user.setPassword(password);
            user.setFullname(fullName);
            user.setMobile(phone);
            user.setAddress(address);
            user.setEmail(email);
            user.setCreatedDate(new Date());
            setRole(user);
            userService.addUser(user);
        } catch (Exception ex) {
            System.out.println("TYPE AGAIN ");
        }
    }



    public void setRole(User user) {
        System.out.println("");
        BannerApp.menuBanner("set-role");
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                user.setRole(Role.USER);
                break;
            case "2":
                user.setRole(Role.ADMIN);
                break;
            default:
                System.out.println("Error Value! Type again.");
                setRole(user);
        }
    }

    public String inputEmail() {
        System.out.print("ENTER EMAIL: ");
        String email;
        do {
            if (!ValidateUtils.isEmailValid(email = scanner.nextLine())) {
                System.out.println("YOUR IS MAIL IS NOT MATCH (ex: chauphuoc1996@gmail.com)");
                System.out.print("ENTER EMAIL AGAIN: ");
                continue;
            }
            if (userService.existsByEmail(email)) {
                System.out.println("YOUR EMAIL IS EXIST, TYPE AGAIN");
                System.out.print("TYPE EMAIL: ");
                continue;
            }
            break;
        } while (true);
        return email;
    }

    private String inputAddress() {
        String address;
        System.out.print("ENTER YOUR ADDRESS ");
        address = scanner.nextLine();
        do {
            if (address.trim().isEmpty()) {
                System.out.println("DONT TYPE SPACE");
                System.out.print("TYPE AGAIN: ");
                address = scanner.nextLine();
            }
        } while (address.trim().isEmpty());
        return address;
    }

    public String inputPhone() {
        String phone;
        do {
            System.out.print("ENTER YOUR PHONENUMBER: ");
            phone = scanner.nextLine();
            if (phone.isEmpty()) {
                break;
            }
            if (!ValidateUtils.isPhoneValid(phone)) {
                System.out.println("YOUR PHONENUMBER IS NOT MATCH (START IS 0 AND HAVE 10 NUMBERS) ");
                continue;
            }
            if (userService.existsByPhone(phone)) {
                System.out.println("THIS PHONENUMBER IS EXIST, TYPE AGAIN");
                System.out.print("ENTER PHONENUMBER: ");
                continue;
            }
            break;
        } while (true);
        return phone;
    }

    public String inputUsername() {
        System.out.print("Username: ");
        String username;

        do {
            if (!ValidateUtils.isUsernameValid(username = SupportApp.retryString())) {
                System.out.println("YOUR USERNAME IS NOT MATCH (>7 charactors, excluding special characters)");
                System.out.println("\"ENTER USERNAME: ");
                continue;
            }
            if (userService.existsByUsername(username)) {
                System.out.println("YOUR USERNAME IS EXIST, TYPE AGAIN");
                System.out.println("ENTER USERNAME: ");
                continue;
            }
            break;
        } while (true);
        return username;
    }

    public String inputPassword(String name) {
        System.out.print("PASSWORD " + name + ": ");
        String password;
        while (!ValidateUtils.isPasswordValid(password = scanner.nextLine())) {
            System.out.println("PASSWORD MUST MINIMUM 8 CHARACTERS, INCLUDING 1 CAPITAL, 1 NUMBER, 1 SPECIAL CHARACTER");
            System.out.print("TYPE PASSWORD AGAIN: ");
        }
        return password;
    }

    public String inputFullName() {
        System.out.print("ENTER FULLNAME: ");
        String fullName;
        while (!ValidateUtils.isNameValid(fullName = scanner.nextLine())) {
            System.out.println("NAME IS NOT MATCH (THE FIRST LETTERS MUST BE CAPITALIZED)");
            System.out.print("ENTER FULLNAME AGAIN: ");
        }
        return fullName;
    }

    private Long inputId(User user) throws Exception {
        Long id;
        boolean isRetry = false;
        do {
            id = Long.parseLong(scanner.nextLine());
            boolean exist = userService.existById(id);
            if (!exist) {
                System.out.println("ID is not exist");
                System.out.println("1.Continue \t|\t 2. Return \t|\t 0. Exit");
                do {
                    String choice = scanner.nextLine();
                    switch (choice) {
                        case "1":
                            inputId(user);
                            break;
                        case "2":
                            menuUser(user);
                            break;
                        case "0":
                            System.exit(5);
                        default:
                            System.out.println("Error Value! Type again!");
                            break;
                    }
                } while (true);
            }

        } while (isRetry);
        return id;
    }
    //
    public void showAllUser() {
        System.out.println("┌──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
        System.out.printf("%10s %20s %20s %20s %15s %11s %25s",
                " ID",
                "NAME",
                "PHONE NUMBER",
                "EMAIL",
                "ADDRESS",
                "ROLE",
                "CREATED DATE");
        System.out.println();
        System.out.println("\t─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        for (User user : userService.showUserView()) {
            System.out.printf("%13s %18s %18s %21s %15s %11s %26s\n",
                    user.getID(),
                    user.getFullname(),
                    user.getMobile(),
                    user.getEmail(),
                    user.getAddress(),
                    user.getRole(),
                    DateUtils.convertDateToString(user.getCreatedDate()));
        }
        System.out.println("└──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘");
    }

}
