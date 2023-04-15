package com.codegym.service;

import com.codegym.comparator.ComparatorDecreasingByPrice;
import com.codegym.comparator.ComparatorIncreasingByPrice;
import com.codegym.feature.BannerApp;
import com.codegym.feature.SupportApp;
import com.codegym.model.ActionType;
import com.codegym.model.ECategory;
import com.codegym.model.Product;
import com.codegym.model.User;
import com.codegym.utils.FileUtils;
import com.codegym.utils.ValidateUtils;
import com.codegym.view.ProductView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductServive {
    public static Scanner scanner = new Scanner(System.in);
    public SupportApp eventApp = new SupportApp();
    public FileUtils fileService;
    public BannerApp bannerApp = new BannerApp();
    public static ProductView productView = new ProductView();
    private final String filePath = "F:\\BaoThi\\MD2_CaseStudy\\src\\main\\java\\com\\codegym\\data\\product.csv";

    public ProductService() {
        fileService = new FileUtils();
    }

    public List<Product> getAllProducts(){
        List<String> productLines = fileService.readFile(filePath);
        List<Product> products = converListStringToListProduct(productLines);
        return products;
    }

    public boolean checkRemainQuantityProduct (long idProduct,int quantity){
        Product product = findProductByID(idProduct);
        if (product.getQuantity()>quantity){
            return true;
        }
        else return false;
    }

    public List<Product> converListStringToListProduct(List<String> list){
        List<Product> products = new ArrayList<>();
        for (String item : list){
            String[] items = item.split(",");
            long idProduct = Long.parseLong(items[0]);
            String nameProduct = items[1];
            int quantity = Integer.parseInt(items[2]);
            double price = Double.parseDouble(items[3]);
            int idCategory = Integer.parseInt(items[4]);
            ECategory category = ECategory.findCategoryByID(idCategory);
            Product product = new Product();
            product.setIdProduct(idProduct);
            product.setPrice(price);
            product.setQuantity(quantity);
            product.setCategory(category);
            product.setNameProduct(nameProduct);
            products.add(product);
        }
        return products;
    }

    public List<String> converListProductToListString(List<Product> productList){
        List<String> productLines = new ArrayList<>();
        for (Product product : productList){
            productLines.add(product.toData());
        }
        return productLines;
    }
    public void addProduct(Product product){
        List<Product> products = getAllProducts();
        products.add(product);
        List<String> productLines = converListProductToListString(products);
        fileService.writeFile(filePath,productLines);
    }

//    Tìm product theo ID product => xây dựng hàm update Product, update product đó và ghi file

    public void updateProduct (Product product,long idProduct){
        List<Product> productList = getAllProducts();
        for (Product p : productList){
            if (p.getIdProduct()==idProduct){
                p.updateProduct(product);
            }
        }
        List<String> productLines = converListProductToListString(productList);
        fileService.writeFile(filePath,productLines);
    }

    public Product findProductByID(long id) {
        for (Product product: getAllProducts()){
            if (product.getIdProduct()==id){
                return product;
            }
        }
        return null;
    }

    public String inputProductName (){
        String nameProduct;
        boolean checkContinueAction;
        do {
            checkContinueAction = true;
            System.out.print("【1】ADD NAME PRODUCT");
            nameProduct = scanner.nextLine();
            if (ValidateUtils.validateProductName(ValidateUtils.removeAccent(nameProduct))){
                checkContinueAction = false;
            }
            else System.out.println("The name of product you entered DO NOT MATCH - please try again.");
        }
        while (checkContinueAction);
        return nameProduct;
    }

    public long inputPrice (ActionType type){
        long price;
        boolean checkInputPrice = false;
        switch (type){
            case Add:
                System.out.println("■ Added Value:");
                break;
            case Edit:
                System.out.println("■ Edited Value:");
                break;
        }
        do {
            checkInputPrice = false;
            price = Long.parseLong(scanner.nextLine());
            if (price<0||price>1000000){
                System.out.println("Price must be less than 1000000 and greater than 0");
                checkInputPrice = true;
            }
        }
        while (checkInputPrice);
        return price;
    }

    public void removeProductByID(long idRemove, List<Product> products, User user) throws Exception {
        String alert = scanner.nextLine();
        if (alert.toLowerCase().equals("y")) {
            for (int i = 0;i< products.size();i++){
                if (products.get(i).getIdProduct()==idRemove){
                    products.remove(i);
                }
            }
            saveData(products);
        }
        if (alert.toLowerCase().equals("n")) {
            productView.mainMenuView(user);
        }

    }


    @Override
    public List<Product> searchProductByName(String name) {
        List<Product> productsResult = new ArrayList<>();
        for (Product product : getAllProducts()){
            if (product.getNameProduct().toUpperCase().contains(name)){
                productsResult.add(product);
            }
        }
        return productsResult;
    }

    @Override
    public void sortByPrice(List<Product> products) {
        boolean checkSortByPrice = false;
        do {
            checkSortByPrice = false;
            bannerApp.menuBanner("Sort-by-price");
            int choiceSortByPrice = Integer.parseInt(scanner.nextLine()) ;
            Comparator comparator;
            switch (choiceSortByPrice){
                case 1:
                    comparator = new ComparatorIncreasingByPrice();
                    products.sort(comparator);
                    saveData(products);
                    ProductView productView1 = new ProductView();
//                    productView1.showProductPagination(products);
                    productView1.showProductView(products);
                    break;
                case 2:
                    comparator = new ComparatorDecreasingByPrice();
                    products.sort(comparator);
                    saveData(products);
                    ProductView productView2 = new ProductView();
//                    productView2.showProductPagination(products);
                    productView2.showProductView(products);

                    break;
                case 0:
                    break;
                default:
                    System.out.println("Error value! Type again");
                    checkSortByPrice = true;
                    break;
            }
        }
        while (checkSortByPrice);
    }


//    public boolean beExistbyID (long id){
//        for (Product product: getAllProducts()){
//            if (product.getIdProduct()==id){
//                return true;
//            }
//        }
//        return false;
//    }

    public void saveData(List<Product> products){
        List<String> productLines = converListProductToListString(products);
        fileService.writeFile(filePath,productLines);
    }

    public void printingAllProduct (){
        for (Product i : getAllProducts()){
            System.out.println(i);
        }
    }

}
