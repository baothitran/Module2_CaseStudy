package com.codegym.model;

public enum ECategory {
BAG("1"),SHOES("2"),PERFUME("3");
    private String value;

    ECategory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    public static boolean fromValue(String value) {
        ECategory[] values = values();
        for (ECategory type : values) {
            if (type.value.equals(value))
                return true;
        }

        return false;
    }
}
