package com.codegym.model;

public enum Role {
    ADMIN("Admin") , USER("User");
    private String value;
    Role (String value){
        this.value = value;
    }
    public static Role findRoleByString (String name){
        for (Role role : values()) {
            String temp = String.valueOf(role);
            if (temp.equals(name)) {
                return role;
            }
        }
        return null;
    }



}
