package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.model.User;

import java.util.List;

public interface IProductServive {
    void addProduct(Product product);

    void updateProduct(Product product, long id);

    void removeProductByID (long id, List<Product> products, User user) throws Exception;
    Product findProductByID(long id);

    List<Product> searchProductByName(String name);

    void sortByPrice(List<Product> products);




}
