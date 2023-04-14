package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.utils.FileUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ProductService implements IProductService{
    private static ProductService instance;
    public static final String PATHPRODUCT ="F:\\BaoThi\\Module2_CaseStudy\\src\\main\\java\\com\\codegym\\data\\product.csv";

    public static ProductService getInstance() {
        if (instance == null)
            instance = new ProductService();
        return instance;
    }
    @Override
    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();
        List<String> products = FileUtils.read(PATHPRODUCT);
        for (String product : products) {
            productList.add(new Product(product));
        }
        return productList;
    }

    @Override
    public Product findById(long id) {
        List<Product> productList = getAll();
        for (Product product : productList) {
            if (product.getProductId() == id)
                return product;
        }
        return null;
    }


    public void searchByName(String name) {
        List<Product> productList = getAll();
        for (Product product : productList) {
            if (product.getProductName().toLowerCase().replace(" ","").equals(name.replace(" ",""))) {
                System.out.printf("\nSan pham ban muon tim kiem la: \n█  ID:  %s █ Ten san pham:  %s █ So luong:  %s █ Gia san pham:  %s █ Loai:  %s  █\n\n",
                        product.getProductId(),
                        product.getProductName(),
                        product.getQuantity(),
                        product.getPrice(),
                        product.getCategory());

                return;
            }
        }
    }

    @Override
    public void searchById(long id) {

    }

    @Override
    public void searchById(Long id) {
        List<Product> productList = getAll();
        for (Product product : productList) {
            if (product.getProductId().equals(id)) {
                System.out.printf("\nSan pham ban muon tim kiem la: \n█  ID:  %s █ Ten san pham:  %s █ So luong:  %s █ Gia san pham:  %s █ Loai:  %s  █\n\n",
                        product.getProductId(),
                        product.getProductName(),
                        product.getQuantity(),
                        product.getPrice(),
                        product.getCategory());

                return;
            }
        }
    }

    @Override
    public boolean existsById(long id) {
        return findById(id) != null;
    }

    @Override
    public void add(Product newProduct) {

        List<Product> productList = getAll();
        for (Product product : productList) {
            String newname = newProduct.getProductName().replace(" ", "").toLowerCase();
            String nameProduct = product.getProductName().replace(" ", "").toLowerCase();
            if (newname.equals(nameProduct) && newProduct.getPrice().equals(product.getPrice())) {
                product.setQuantity(product.getQuantity() + newProduct.getQuantity());
                FileUtils.write(PATHPRODUCT, productList);
                return;
            }
        }
        productList.add(newProduct);
        FileUtils.write(PATHPRODUCT, productList);
    }

    @Override
    public void update(Product newProduct) {
        List<Product> productList = getAll();
        for (Product product : productList) {
            if (newProduct.getProductId().equals(product.getProductId())) {
                if (newProduct.getProductName() != null && !newProduct.getProductName().isEmpty())
                    product.setProductName(newProduct.getProductName());
                if (newProduct.getPrice() != null)
                    product.setPrice(newProduct.getPrice());
                if (newProduct.getQuantity() != null)
                    product.setQuantity(newProduct.getQuantity());
                FileUtils.write(PATHPRODUCT, productList);
            }
        }
    }

    @Override
    public void remove(int idProduct) {
        List<Product> productList = getAll();
        for (Product product : productList) {
            if (product.getProductId() == idProduct) {
                System.out.println(product);
                productList.remove(product);
                FileUtils.write(PATHPRODUCT, productList);
                return;
            }
        }
    }

    @Override
    public Product sortQuantityASC() {
        List<Product> productList = getAll();
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                double result = (o1.getPrice() - o2.getPrice());
                if (result == 0)
                    return 0;
                return (o1.getPrice() - o2.getPrice()) > 0 ? 1 : -1;
            }
        });
        FileUtils.write(PATHPRODUCT, productList);
        return null;
    }

    @Override
    public Product sortQuantityDESC() {
        List<Product> productList = getAll();
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                double result = (o2.getPrice() - o1.getPrice());
                if (result == 0)
                    return 0;
                return result > 0 ? 1 : -1;
            }
        });
        FileUtils.write(PATHPRODUCT, productList);
        return null;
    }

    @Override
    public void updateQuantity(long id, int quantity) {
        List<Product> productList = getAll();
        for (Product product : productList) {
            if (product.getProductId() == id) {
                if (product.getQuantity() >= quantity) {
                    product.setQuantity(product.getQuantity() - quantity);
                    FileUtils.write(PATHPRODUCT, productList);
                    break;
                }
            }
        }
    }
}
