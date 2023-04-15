package com.codegym.model;

public class Product {
    private long idProduct;
    private String nameProduct;
    private double price;
    private int quantity;
    private ECategory category;

    public Product() {
    }

    public Product(long idProduct, String nameProduct, double price, int quantity, ECategory category) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ECategory getCategory() {
        return category;
    }

    public void setCategory(ECategory category) {
        this.category = category;
    }

    public void updateProduct (Product product){
        this.setIdProduct(product.getIdProduct());
        this.setNameProduct(product.getNameProduct());
        this.setPrice(product.getPrice());
        this.setQuantity(product.getQuantity());
        this.setCategory(product.getCategory());
    }
    @Override
    public String toString() {
        return
                String.format("║%10s║ %20s║ %20s║ %10s║ %10s║",this.idProduct,this.nameProduct,this.price,this.quantity,this.category);
    }
    public String toData(){
        return String.format("%s,%s,%s,%s,%s",this.idProduct,this.nameProduct,this.quantity,this.price,category.getIdCategory());
    }
}