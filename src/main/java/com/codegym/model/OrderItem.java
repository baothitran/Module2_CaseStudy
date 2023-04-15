package com.codegym.model;

import com.codegym.service.ProductService;

public class OrderItem {
    ProductService productService = new ProductService();

    private long id;
    private long idProduct;
    private long idOrder;
    private int quantity;
    private double price;


    public OrderItem() {

    }

    public OrderItem(long id, long idProduct, long idOrder, int quantity, double price) {
        this.id = id;
        this.idProduct = idProduct;
        this.idOrder = idOrder;
        this.quantity = quantity;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String toData (){
        return String.format("%s,%s,%s,%s,%s",this.id,this.idProduct,this.idOrder,this.quantity,this.price);
    }

    @Override
    public String toString() {
        Product product = productService.findProductByID(this.idProduct);
        return String.format("%10s %12s %53s %17s %15s", this.id, this.idOrder, product.getNameProduct(), this.price, this.quantity);

    }


}
