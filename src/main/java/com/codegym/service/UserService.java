package com.codegym.service;

import com.codegym.model.Order;
import com.codegym.model.Role;
import com.codegym.model.Status;
import com.codegym.model.User;
import com.codegym.utils.DateUtils;
import com.codegym.utils.FileUtils;
import com.codegym.view.LoginUserView;
import com.codegym.view.ManagerUserView;
import com.codegym.view.OrderView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserService implements IUserService {
    final String Path = "F:\\BaoThi\\Module2_CaseStudy\\src\\main\\java\\com\\codegym\\data\\user.csv";
    FileUtils fileService = new FileUtils();
    public OrderView orderView = new OrderView();
    private static UserService userService;
    private OrderService orderService = new OrderService();
    public static ManagerUserView managerUserView = new ManagerUserView();
    static LoginUserView loginUserView = new LoginUserView();
    public static Scanner scanner = new Scanner(System.in);

    public UserService() {
    }


    @Override
    public List<User> showUserView() {
        List<User> userList = new ArrayList<>();
        List<String> stringList = fileService.readFile(Path);
        for (String lines : stringList) {
            String[] line = lines.split(",");
            long idUser = Long.parseLong(line[0]);
            Role role = Role.findRoleByString(line[7]);
            User newUser = new User(idUser, line[1], line[2], line[3], line[4], line[5], line[6], role);
            Date createdDate = DateUtils.convertStringToDate(line[8]);
            newUser.setCreatedDate(createdDate);
            userList.add(newUser);
        }
        return userList;
    }

    @Override
    public void add(User newUser) {
        newUser.setCreatedDate(new Date());
        List<User> users = new ArrayList<>();
        users.add(newUser);
        saveUserData(users);
    }

    @Override
    public void update(User newUser) {
        List<User> users = showUserView();
        for (User user : users) {
            if (user.getID() == (newUser.getID())) {
                String fullName = newUser.getFullname();
                if (fullName != null && !fullName.isEmpty())
                    user.setFullname(fullName);
                String phone = newUser.getMobile();
                if (phone != null && !phone.isEmpty())
                    user.setMobile(newUser.getMobile());
                String address = newUser.getAddress();
                if (address != null && !address.isEmpty())
                    user.setAddress(newUser.getAddress());
                String email = newUser.getEmail();
                if (email != null && !email.isEmpty()) {
                    user.setEmail(newUser.getEmail());
                }
                saveUserData(users);
                break;
            }
        }

    }


    @Override
    public void removeUser(Long idUser, User user) throws Exception {
        String alert = scanner.nextLine();
        if (alert.toLowerCase().equals("y")) {
            List<User> users = showUserView();
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getID() == idUser) {
                    users.remove(i);
                    break;
                }
            }
            saveUserData(users);
        }
        if (alert.toLowerCase().equals("n")) {
            managerUserView.menuUser(user);
        }


    }

    public void saveUserData(List<User> users) {
        List<String> userLines = converListUserToListString(users);
        fileService.writeFile(Path, userLines);
    }

    public List<String> converListUserToListString(List<User> users) {
        List<String> userLines = new ArrayList<>();
        for (User user : users) {
            userLines.add(user.toData());
        }
        return userLines;
    }

    @Override
    public boolean existById(Long id) {
        if (findUserById(id) != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean existsByEmail(String email) {
        List<User> users = showUserView();
        for (User user : users) {
            if (user.getEmail().equals(email))
                return true;
        }
        return false;
    }

    @Override
    public boolean existsByPhone(String phone) {
        List<User> users = showUserView();
        for (User user : users) {
            if (user.getMobile().equals(phone))
                return true;
        }
        return false;
    }

    @Override
    public boolean existsByUsername(String userName) {
        List<User> users = showUserView();
        for (User user : users) {
            if (user.getAccount().equals(userName))
                return true;
        }
        return false;
    }

    @Override
    public User findUserById(Long id) {
        List<User> users = showUserView();
        for (User user : users) {
            if (user.getID() == id)
                return user;
        }
        return null;
    }

    public static UserService getUserService() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }


    @Override
    public User adminLogin(String username, String password) {
        List<User> users = showUserView();
        for (User user : users) {
            if (user.getAccount().equals(username) && user.getPassword().equals(password) && user.getRole().equals(Role.ADMIN)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User userLogin(String username, String password) {
        List<User> users = showUserView();
        for (User u : users) {
            if (u.getAccount().equals(username) && u.getPassword().equals(password) && u.getRole().equals(Role.USER)) {
                return u;
            }
        }
        return null;
    }

    public void addUser(User user) {
        List<User> users = userService.showUserView();
        users.add(user);
        List<String> userLine = userService.converListUserToListString(users);
        fileService.writeFile(Path, userLine);
    }

//    public String inputNewPassword() {
//        System.out.print("ENTER NEW PASSWORD: ");
//        String password;
//        while (!ValidateUtils.isPasswordValid(password = scanner.nextLine())) {
//            System.out.println("PASS WORD MUST <= 8 CHARACTERS, INCLUDING 1 CAPITAL LETTER,1 NUMBER, 1 SPECIAL CHARATER");
//            System.out.print("TRY AGAIN: ");
//        }
//        return password;
//    }

//    public void changePasswordtest() {
//        String checkPassOld = null;
//        String passNew = null;
//        String passNewCheck = null;
//        User user = new User();
//        user.setAccount(loginUserView.name);
//        System.out.println("ENTER OLD PASSWORD: ");
//        String passOld = InitApp.isNotEmpty();
//        for (User u : userService.showUserView()) {
//            if (u.getPassword().equals(passOld)) {
//                boolean checkFlag = true;
//                do {
//                    passNew = inputNewPassword();
//                    if (passNew.equals(checkPassOld)) {
//                        System.out.println("NEW PASSWORD IS MATCH OLD PASSWORD, TYPE AGAIN");
//                    } else {
//                        checkFlag = false;
//                    }
//                } while (checkFlag);
//                System.out.println("TYPE NEW PASSWORD AGAIN");
//                boolean checkAgain = true;
//                do {
//                    passNewCheck = scanner.nextLine();
//                    if (passNew.equals(passNewCheck)) {
//                        user.setPassword(passNewCheck);
//                        updatePW(user);
//                        System.out.println("Change password successfull!");
//                        break;
//                    } else {
//                        System.out.println("These password is not match together");
//                        System.out.println("Type again: ");
//                        checkAgain = true;
//                    }
//                } while (checkAgain);
//            } else {
//                System.out.println("☼☼☼ MẬT KHẨU KHÔNG ĐÚNG ☼☼☼");
//                break;
//            }
//            break;
//        }
//    }
//
//    public void updatePW(User newUser) {
//        List<User> users = showUserView();
//        for (User user : users) {
//            if (user.getAccount().equals(newUser.getAccount())) {
//                user.setPassword(newUser.getPassword());
//                saveUserData(users);
//                break;
//            }
//        }
//    }


    public void getOrderbyIDUser(User user) {
        List<Order> orderListResult = new ArrayList<>();
        List<Order> orders = orderService.getAllOrderList();
        for (Order order : orders) {
            if (order.getIdUser() == user.getID() && order.getStatus().equals(Status.Paid)) {
                orderListResult.add(order);
            }
        }
        orderView.printingAllOrders(orderListResult, user);
    }
}