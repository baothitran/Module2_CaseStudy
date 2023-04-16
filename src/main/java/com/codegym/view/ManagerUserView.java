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
    public static ProductAdminView productAdminView = new ProductAdminView();

    public ManagerUserView() {
        userService = UserService.getUserService();
    }

    public void menuUser(User user) throws Exception {
        boolean checkMenuUser;
        System.out.println("");
        BannerApp.menuBanner("List-User");
        do {
            checkMenuUser = false;
            int choice = Integer.parseInt(scanner.nextLine());
            List<User> userList = userService.showUserView();
            switch (choice) {
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
        } while (checkMenuUser);
    }

    public void removeUser(User user) throws Exception {
        boolean checkRemoveAction;
        do {
            checkRemoveAction = false;
            showAllUser();
            System.out.println("Nhập ID người dùng bạn muốn xoá: ");
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
                System.out.println("Nhập ID người dùng bạn muốn chỉnh sửa:");
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
                System.out.println("Lỗi! Vui lòng nhập lại: ");
            }
        } while (isRetry);
    }

    public void addUserView(List<User> users) {
        try {
            User user = new User();
            Long id = System.currentTimeMillis() / 10000;
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
            System.out.println("Lỗi! Vui lòng nhập lại: ");
        }
    }



    public void setRole(User user) {
        System.out.println("");
        BannerApp.menuBanner("set-role");
        int option = Integer.parseInt(scanner.nextLine());
        switch (option) {
            case 1:
                user.setRole(Role.USER);
                break;
            case 2:
                user.setRole(Role.ADMIN);
                break;
            default:
                System.out.println("Lỗi! Vui lòng nhập lại:");
                setRole(user);
        }
    }

    public String inputEmail() {
        System.out.print("Nhập email: ");
        String email;
        do {
            if (!ValidateUtils.isEmailValid(email = scanner.nextLine())) {
                System.out.println("Email không đúng cú pháp! Vui lòng nhập lại");
                System.out.print("Nhập email: ");
                continue;
            }
            if (userService.existsByEmail(email)) {
                System.out.println("Email đã tồn tại! Vui lòng nhập lại");
                System.out.print("Nhập email: ");
                continue;
            }
            break;
        } while (true);
        return email;
    }

    private String inputAddress() {
        String address;
        System.out.print("Nhập địa chỉ:  ");
        address = scanner.nextLine();
        do {
            if (!ValidateUtils.isAddressValid(address)) {
                System.out.println("Địa chỉ không đúng! Vui lòng nhập lại");
                System.out.print("Nhập địa chỉ: ");
                address = scanner.nextLine();
                continue;
            }
            if (address.trim().isEmpty()) {
                System.out.println("Vui lòng không để trống");
                System.out.print("Nhập địa chỉ: ");
                address = scanner.nextLine();
            }
        } while (address.trim().isEmpty());
        return address;
    }

    public String inputPhone() {
        String phone;
        do {
            System.out.print("Nhập số điện thoại: ");
            phone = scanner.nextLine();
            if (phone.isEmpty()) {
                break;
            }
            if (!ValidateUtils.isPhoneValid(phone)) {
                System.out.println("Số điện thoại phải có 10 chữ số và bắt đầu bằng số 0 ");
                continue;
            }
            if (userService.existsByPhone(phone)) {
                System.out.println("Số điện thoại đã tồn tại! Vui lòng nhập lại: ");
                System.out.print("Nhập số điện thoại: ");
                continue;
            }
            break;
        } while (true);
        return phone;
    }

    public String inputUsername() {
        System.out.print("Nhập tên tài khoản: ");
        String username;

        do {
            if (!ValidateUtils.isUsernameValid(username = SupportApp.retryString())) {
                System.out.println("Tên tài khoản không phù hợp (trên 3 ký tự và không chứa các ký tự đặc biệt)");
                System.out.println("\"Nhập tên tài khoản: ");
                continue;
            }
            if (userService.existsByUsername(username)) {
                System.out.println("Tên tài khoản đã tồn tại! Vui lòng nhập lại");
                System.out.println("Nhập tên tài khoản: ");
                continue;
            }
            break;
        } while (true);
        return username;
    }

    public String inputPassword(String name) {
        System.out.print("Mật khẩu " + name + ": ");
        String password;
        while (!ValidateUtils.isPasswordValid(password = scanner.nextLine())) {
            System.out.println("Mật khẩu phải có ít nhất 6 ký tự, bao gồm 1 chữ viết hoa, 1 số, 1 ký tự đặc biệt");
            System.out.print("Nhập mật khẩu: ");
        }
        return password;
    }

    public String inputFullName() {
        System.out.print("Nhập tên: ");
        String fullName;
        while (!ValidateUtils.isNameValid(fullName = scanner.nextLine())) {
            System.out.println("Chữ cái đầu phải viết hoa");
            System.out.print("Nhập tên: ");
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
                System.out.println("ID không tồn tại");
                System.out.println("1. Tiếp tục \t|\t 2. Trở về \t|\t 0. Thoát");
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
                            System.out.println("Lỗi! Mời nhập lại: ");
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
                "Tên người dùng",
                "Điện thoại",
                "Email",
                "Địa chỉ",
                "Vai trò",
                "Ngày tạo");
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
