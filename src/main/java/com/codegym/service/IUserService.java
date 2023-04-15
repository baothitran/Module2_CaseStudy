package com.codegym.service;

import com.codegym.model.User;

import java.util.List;

public interface IUserService {
    List<User> showUserView ();

    User userLogin(String username, String password);
    void add(User newUser);

    void update(User newUser);


    void removeUser(Long idUser, User user) throws Exception;

    boolean existById(Long id);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

    boolean existsByUsername(String userName);

    public User findUserById(Long id);

    User adminLogin(String username, String password);
}
