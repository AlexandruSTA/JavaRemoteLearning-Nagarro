package com.nagarro.week2.extra.product;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<FoodProduct> foodProducts = new ArrayList<>();
        foodProducts.add(new Chocolate());
        foodProducts.add(new Chocolate());

        List<ElectricalProduct> electricalProducts = new ArrayList<>();
        electricalProducts.add(new Phone());
        electricalProducts.add(new Laptop());


        List<Product> products = new ArrayList<>();
        products.add(new Chocolate());
        products.add(new Phone());
        products.add(new Laptop());

        printExpirationDateStatistics(foodProducts);
        printWarrantyStatistics(electricalProducts);
        printProductsName(products);
    }

    private static void printExpirationDateStatistics(List<FoodProduct> foodProducts) {
        System.out.println("================== FoodProducts ExpirationDate Statistics ==================");
        for (FoodProduct product : foodProducts) {
            System.out.println(product.getExpirationDate());
        }
        System.out.println("========================================================================");
    }

    private static void printWarrantyStatistics(List<ElectricalProduct> electricalProducts) {
        System.out.println("================== ElectricalProducts Warranty Statistics ==================");
        for (ElectricalProduct product : electricalProducts) {
            System.out.println(product.getWarranty());
        }
        System.out.println("========================================================================");
    }

    private static void printProductsName(List<Product> products) {
        System.out.println("================== Products Name Details ==================");
        for (Product product : products) {
            System.out.println(product.getName());
        }
        System.out.println("========================================================================");
    }
}
