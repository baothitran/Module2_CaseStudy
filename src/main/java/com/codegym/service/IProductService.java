package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    Product findById(long id);
    void searchByName(String name);
    void searchById(long id);

    void searchById(Long id);

    boolean existsById(long id);
    void add(Product newProduct);
    void update(Product newProduct);
    void remove(int newProduct);
    Product sortQuantityASC();
    Product sortQuantityDESC();

    void updateQuantity(long id, int quantity);

}
