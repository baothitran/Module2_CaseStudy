package com.codegym.service;

import com.codegym.model.Role;
import com.codegym.model.User;
import com.codegym.utils.FileUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {
    public final static String PATH = "F:\\BaoThi\\Module2_CaseStudy\\src\\main\\java\\com\\codegym\\data\\users.csv";
    private static UserService instance;

    private UserService() {
    }


    public static UserService getInstance() {
        if (instance == null)
            instance = new UserService();
        return instance;
    }


    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        List<String> records = FileUtils.read("F:\\Test3\\CaseStudy_m2\\CaseStudy\\data\\users.csv");
        for (String record : records) {
            users.add(User.parseUser(record));
        }
        return users;
    }

    @Override
    public User adminLogin(String account, String password) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getAccount().equals(account) && user.getPassword().equals(password)
                    && user.getRole().equals(Role.ADMIN)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void deleteUser(User newUser) {
        List<User> users = findAll();
        for (User user : users) {
            if (newUser.getID().equals(user.getID())) {
                if (user.getRole().equals(Role.USER)) {
                    users.remove(user);
                }
                FileUtils.write(PATH, users);
            }
        }
    }

    @Override
    public void add(User newUser) {
        newUser.setID(System.currentTimeMillis() / 1000);
        newUser.setCreatedAt(Instant.now());
        List<User> users = findAll();
        users.add(newUser);
        FileUtils.write(PATH, users);
    }

    @Override
    public void update(User newUser) {
        List<User> users = findAll();
        for (User user : users) {

            if (user.getID().equals(newUser.getID())) {
                String fullName = newUser.getFullname();
                if (fullName != null && !fullName.isEmpty())
                    user.setFullname(fullName);
                String phone = newUser.getPhone();
                if (phone != null && !phone.isEmpty())
                    user.setPhone(newUser.getPhone());
                String address = newUser.getAddress();
                if (address != null && !address.isEmpty())
                    user.setAddress(newUser.getAddress());
                String email = newUser.getEmail();
                if (email != null && !email.isEmpty())
                    user.setEmail(newUser.getEmail());
                FileUtils.write(PATH, users);
                break;
            }
        }
    }

    @Override
    public boolean existById(int id) {
        return findById(id) != null;
    }

    @Override
    public boolean existsByEmail(String email) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getEmail().equals(email))
                return true;
        }
        return false;
    }

    @Override
    public boolean existsByPhone(String phone) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getPhone().equals(phone))
                return true;
        }
        return false;
    }

    @Override
    public boolean existsByUserName(String userName) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getAccount().equals(userName))
                return true;
        }
        return false;
    }

    @Override
    public User findById(int id) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getID() == id)
                return user;
        }
        return null;
    }
}
