package com.codegym.view;

import com.codegym.feature.BannerApp;
import com.codegym.feature.InitApp;
import com.codegym.model.ActionType;
import com.codegym.model.ECategory;
import com.codegym.model.Product;
import com.codegym.model.User;
import com.codegym.service.ProductService;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    public static Scanner scanner = new Scanner(System.in);
    static ProductService productService = new ProductService();
    static ProductAdminView productAdminView = new ProductAdminView();

    BannerApp bannerApp = new BannerApp();

    public void mainMenuView(User user) throws Exception {
        boolean checkMenuAction = false;
        List<Product> products;
        do {
            products = productService.getAllProducts();
            bannerApp.menuBanner("Product-ViewMenu");
            int choiceMenuAction = Integer.parseInt( scanner.nextLine());
            switch (choiceMenuAction) {
                case 1:
                    addProductView();
                    checkMenuAction = InitApp.checkContinueActionMenu();
                    break;
                case 2:
                    updateProductView(products, user);
                    checkMenuAction = InitApp.checkContinueActionMenu();
                    break;
                case 3:
                    removeProductView(products, user);
                    checkMenuAction = InitApp.checkContinueActionMenu();
                    break;
                case 4:
                    searchProductView(user);
                    checkMenuAction = InitApp.checkContinueActionMenu();
                    break;
                case 5:
                    sortProductView(products, user);
                    checkMenuAction = InitApp.checkContinueActionMenu();
                    break;
                case 6:
                    showProductView(products);
                    checkMenuAction = InitApp.checkContinueActionMenu();
                    break;
                case 0:
                    System.exit(5);
                    break;
                case 7:
                    productAdminView.menuAdminView(user);
                default:
                    checkMenuAction = true;
                    break;
            }
        }
        while (checkMenuAction);
    }

    public void addProductView() {
        Product product = new Product();
        List<Product> productList = productService.getAllProducts();
        boolean checkAddProductMenu = false;
        do {
            checkAddProductMenu = false;
            try {
                bannerApp.menuBanner("Product-Service");
                System.out.println();
                product.setIdProduct(System.currentTimeMillis() / 100000);
                String nameProduct = productService.inputProductName();
                product.setNameProduct(nameProduct);
                System.out.print("【2】Giá sản phẩm");
                long priceProduct = Long.parseLong(scanner.nextLine());
                product.setPrice(priceProduct);
                System.out.print("【3】Số lượng sản phẩm");
                int quantityProduct = Integer.parseInt(scanner.nextLine());
                product.setQuantity(quantityProduct);
                System.out.print("【4】ID Danh mục sản phẩm");
                int idCategory = Integer.parseInt(scanner.nextLine());
                product.setCategory(ECategory.findCategoryByID(idCategory));
                checkAddProductMenu = false;
                productService.addProduct(product);
            } catch (Exception e) {
                System.out.println("Lỗi! Vui lòng nhập lại");
                checkAddProductMenu = true;
            }
        }
        while (checkAddProductMenu);
    }

    public void updateProductView(List<Product> products, User user) throws Exception {
        Product product;
        boolean checkUpdateProduct = false;
        showProductView(products);
        System.out.println("■ Nhập ID sản phẩm:");
        int choiceIDProduct = Integer.parseInt(scanner.nextLine());
        product = productService.findProductByID(choiceIDProduct);
        do {
            checkUpdateProduct = false;
            bannerApp.menuBanner("Update-product");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    String name = productService.inputProductName();
                    product.setNameProduct(name);
                    checkUpdateProduct = InitApp.checkContinueUpdateMenu();
                    break;
                case "2":
                    int quantity = Integer.parseInt(scanner.nextLine());
                    product.setQuantity(quantity);
                    checkUpdateProduct = InitApp.checkContinueUpdateMenu();
                    break;
                case "3":
                    product.setPrice(productService.inputPrice(ActionType.Edit));
                    checkUpdateProduct = InitApp.checkContinueUpdateMenu();
                    break;
                case "4":
                    mainMenuView(user);
                default:
                    checkUpdateProduct = true;
                    break;
            }
            productService.updateProduct(product, choiceIDProduct);
        }
        while (checkUpdateProduct);
    }

    public void sortProductView(List<Product> products, User user) throws Exception {
        boolean checkSortProduct = false;
        do {
            checkSortProduct = false;
            bannerApp.menuBanner("Sort-Product-Menu");
            String choiceSortProduct = scanner.nextLine();
            switch (choiceSortProduct) {
                case "1":
                    productService.sortByPrice(products);
                    break;
                case "2":
                    mainMenuView(user);
                default:
                    checkSortProduct = true;
                    break;
            }
        }
        while (checkSortProduct);
    }

    public void searchProductView(User user) throws Exception {
        try {
            boolean checkSearchingProduct = false;
            do {
                Product product;
                checkSearchingProduct = false;
                bannerApp.menuBanner("Searching-Product");
                String choiceSearching = scanner.nextLine();
                switch (choiceSearching) {
                    case "1":
                        System.out.println("■ Nhập ID sản phẩm:");
                        long idProduct = Long.parseLong(scanner.nextLine());
                        product = productService.findProductByID(idProduct);
                        System.out.printf("%10s %47s %18s %16s %12s", "ID", "Tên sản phẩm", "Giá", "Số lượng", "Loại");
                        System.out.println();
                        System.out.println(product);
                        break;
                    case "2":
                        System.out.println("■ Nhập tên sản phẩm:");
                        String name = scanner.nextLine().toUpperCase();
                        List<Product> products = productService.searchProductByName(name);
                        showProductView(products);
                        break;
                    case "r":
                        mainMenuView(user);
                    default:
                        System.out.println("Lỗi! Vui lòng nhập lại");
                        checkSearchingProduct = true;
                        break;
                }
            }
            while (checkSearchingProduct);
        } catch (Exception e) {
            throw new Exception("Lỗi");
        }
    }


    public void removeProductView(List<Product> products, User user) throws Exception {
        System.out.println("■ Nhập ID sản phẩm:");
        int idRemovedProduct = Integer.parseInt(scanner.nextLine());
        productService.removeProductByID(idRemovedProduct, products, user);
    }

    public void showProductView(List<Product> products) {
        System.out.println("╔═════════════════════════════════════════════════DANH SÁCH SẢN PHẨM════════════════════════════════════════════╗");
        System.out.printf("║%10s║ %53s║ %15s║ %10s║ %15s║", "ID", "Tên sản phẩm", "Giá", "Số lượng", "Loại");
        System.out.println();
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }
}