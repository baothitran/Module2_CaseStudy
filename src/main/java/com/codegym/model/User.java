package com.codegym.model;


import java.util.Date;

public class User {
    private Long ID;
    private String account;
    private String password;
    private String fullname;
    private String phone;
    private String email;
    private String address;
    private Role role;
    private Date createdDate;
    public User() {
    }

    public User(long ID, String account, String password, String fullname, String phone, String email, String address, Role role, Date createdDate) {
        this.ID = ID;
        this.account = account;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.role = role;
        this.createdDate = createdDate;
    }


    public static User parseUser(String raw) {
        User user = new User();
        String[] fields = raw.split(",");
        user.ID = Long.parseLong(fields[0]);
        user.account = fields[1];
        user.password = fields[2];
        user.fullname = fields[3];
        user.phone = fields[4];
        user.email = fields[5];
        user.address = fields[6];
        user.role = Role.parseRole(fields[7]);
        user.createdDate = fields[8];
        String temp = fields[9];

        return user;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }


}
