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

    BannerApp bannerApp= new BannerApp();

    public void mainMenuView (User user) throws Exception {
        boolean checkMenuAction = false;
        List<Product> products ;
        do {
            products = productService.getAllProducts();
            bannerApp.menuBanner("Product-ViewMenu");
            String choiceMenuAction = scanner.nextLine();
            switch (choiceMenuAction){
                case "1":
                    addProductView();
                    checkMenuAction= InitApp.checkContinueActionMenu();
                    break;
                case "2":
                    updateProductView(products,user);
                    checkMenuAction = InitApp.checkContinueActionMenu();
                    break;
                case "3":
                    removeProductView(products,user);
                    checkMenuAction = InitApp.checkContinueActionMenu();
                    break;
                case "4":
                    searchProductView(user);
                    checkMenuAction = InitApp.checkContinueActionMenu();
                    break;
                case "5":
                    sortProductView(products,user);
                    checkMenuAction = InitApp.checkContinueActionMenu();
                    break;
                case "6":
//                    showProductPagination(products);
                    showProductView(products);
                    checkMenuAction = InitApp.checkContinueActionMenu();
                    break;
                case "0":
                    System.exit(5);
                    break;
                case "r":
                    productAdminView.menuAdminView(user);
                default:
                    checkMenuAction = true;
                    break;
            }
        }
        while (checkMenuAction);
    }

    public void addProductView() {
        Product product=new Product();
        List<Product> productList = productService.getAllProducts();
        boolean checkAddProductMenu = false;
        do {
            checkAddProductMenu = false;
            try {
                bannerApp.menuBanner("Product-Service");
                System.out.println();
                product.setIdProduct(System.currentTimeMillis()/100000);
                String nameProduct = productService.inputProductName();
                product.setNameProduct(nameProduct);
                System.out.print("【2】ADD PRICE PRODUCT");
                long priceProduct = Long.parseLong(scanner.nextLine());
                product.setPrice(priceProduct);
                System.out.print("【3】ADD QUANTITY PRODUCT");
                int quantityProduct = Integer.parseInt(scanner.nextLine());
                product.setQuantity(quantityProduct);
                System.out.print("【4】ADD ID CATEGORY");
                int idCategory = Integer.parseInt(scanner.nextLine());
                product.setCategory(ECategory.findCategoryByID(idCategory));
                checkAddProductMenu = false;
                productService.addProduct(product);
            }
            catch (Exception e){
                System.out.println("Error value!Type again!");
                checkAddProductMenu = true;
            }
        }
        while (checkAddProductMenu);
    }

    public void updateProductView(List<Product> products,User user) throws Exception {
        Product product;
        boolean checkUpdateProduct = false;
//        showProductPagination(products);
        showProductView(products);
        System.out.println("■ Select ID Product you want to update:");
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
                case "r":
                    mainMenuView(user);
                default:
                    checkUpdateProduct = true;
                    break;
            }
            productService.updateProduct(product,choiceIDProduct);
        }
        while (checkUpdateProduct);
    }
    public void sortProductView(List<Product> products,User user) throws Exception {
        boolean checkSortProduct = false;
        do {
            checkSortProduct = false;
            bannerApp.menuBanner("Sort-Product-Menu");
            String choiceSortProduct = scanner.nextLine();
            switch (choiceSortProduct) {
                case "1":
                    productService.sortByPrice(products);
                    break;
                case "r":
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
                switch (choiceSearching){
                    case "1":
                        System.out.println("■ Enter ID Product:");
                        long idProduct = Long.parseLong(scanner.nextLine());
                        product = productService.findProductByID(idProduct);
                        System.out.printf("%10s %20s %20s %10s %10s","ID","Name product","Price","Quantity","Type");
                        System.out.println();
                        System.out.println(product) ;
                        break;
                    case "2":
                        System.out.println("■ Enter Name Product:");
                        String name = scanner.nextLine().toUpperCase();
                        List<Product> products = productService.searchProductByName(name);
//                        products = productService.searchProductByName(name);
                        showProductView(products);
                        break;
                    case "r":
                        mainMenuView(user);
                    default:
                        System.out.println("Error value! Type again");
                        checkSearchingProduct=true;
                        break;
                }
            }
            while (checkSearchingProduct);
        }
        catch (Exception e){
            throw new Exception("Value Error");
        }
    }


    public void removeProductView(List<Product> products, User user) throws Exception {
        System.out.println("■ Enter your ID Product you want to remove:");
        int idRemovedProduct = Integer.parseInt(scanner.nextLine());
        productService.removeProductByID(idRemovedProduct,products,user);
    }

    public void showProductView(List<Product> products) {
        System.out.println("╔════════════════════════════════LIST PRODUCT══════════════════════════════════╗");
        System.out.printf("║%10s║ %20s║ %20s║ %10s║ %10s║","ID","Name product","Price","Quantity","Type");
        System.out.println();
        for (Product product: products){
            System.out.println(product);
        }
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════╝");
    }

//    public void showProductPagination (List<Product> productList){
//        int perProductPage = 4;
//        int totalPage = (int)Math.ceil((double) productList.size()/perProductPage);
//        int currentPage=1;
//        List<Product> productsPerPageList;
//        if (currentPage == totalPage) {
//            productsPerPageList = productList.subList((currentPage - 1) * perProductPage, productList.size());
//        } else {
//            productsPerPageList = productList.subList((currentPage - 1) * perProductPage, (currentPage - 1) * perProductPage + perProductPage);
//        }
//        System.out.println("╔════════════════════════════════PRODUCT LIST══════════════════════════════════╗");
//        System.out.println(String.format("║%10s║ %20s║ %20s║ %10s║ %10s║", "ID Product", "Name Product", "Price", "Quantity", "Type"));
//        for (Product product : productsPerPageList) {
//            System.out.println(product);
//        }
//        System.out.println("╚══════════════════════════════════════════════════════════════════════════════╝");
//
//        System.out.print("║\t"+"Page:");
//        for (int j = 1; j <= totalPage; j++) {
//            System.out.print("\t"+j+"  " );
//        }
//        showProductPaginationView(totalPage,perProductPage,productList);
//
//    }


    public void showProductPaginationView (int totalPage,int perProductPage,List<Product> productList){
        boolean checkContinueAction;
        do {
            checkContinueAction = false;
            System.out.println();
            System.out.println("Enter your page you want to show:");
            int currentPage = Integer.parseInt(scanner.nextLine());
            if (currentPage<=totalPage){
                List<Product> productsPerPageList1;
                if (currentPage == totalPage) {
                    productsPerPageList1 = productList.subList((currentPage - 1) * perProductPage, productList.size());
                } else {
                    productsPerPageList1 = productList.subList((currentPage - 1) * perProductPage, (currentPage - 1) * perProductPage + perProductPage);
                }
                System.out.println("╔════════════════════════════════PRODUCT LIST══════════════════════════════════╗");
                for (Product product : productsPerPageList1) {
                    System.out.println(product);
                }
                System.out.println("╚══════════════════════════════════════════════════════════════════════════════╝");
                System.out.print("║\t"+"Page:");
                for (int j = 1; j <= totalPage; j++) {
                    System.out.print("\t"+j+" " );
                }
                System.out.println();
                checkContinueAction = InitApp.checkContinueWatchPage();
            }
            else {
                System.out.println("Your page must be less or equal than "+totalPage+". Type again");
                checkContinueAction = true;
            }
        }
        while (checkContinueAction);
    }

}
