package com.codegym.model;

public class Product {
    private Long productId;
    private String productName;
    private Integer quantity;
    private Double price;
    private ECategory category;

    public Product() {
    }

    public Product(long productId, String productName, int quantity, double price, ECategory category) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }

    public Product(String product) {
        String[] items = product.split(",");
        this.productId = Long.parseLong(items[0]);
        this.productName = items[1];
        this.quantity = Integer.parseInt(items[2]);
        this.price = Double.parseDouble(items[3]);
        this.category = ECategory.valueOf(items[4]);
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ECategory getCategory() {
        return category;
    }

    public void setCategory(ECategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s", this.productId, this.productName, this.quantity, this.price, this.category);
    }
}
