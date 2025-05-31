package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class ProductBasket {
    private Map<String, List<Product>> productsMap = new HashMap<>();

    public void addToBasket(Product product) {
        productsMap.computeIfAbsent(product.getProductName(), k -> new ArrayList<>()).add(product);
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removed = productsMap.remove(name);
        return removed != null ? removed : new ArrayList<>();
    }

    public int totalCostBasket() {
        int sum = 0;
        for (List<Product> productList : productsMap.values()) {
            for (Product product : productList) {
                if (product != null) {
                    sum += product.getPrice();
                }
            }
        }
        return sum;
    }

    public void printBasket() {
        if (productsMap.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        int specialProduct = 0;
        int totalItems = 0;

        for (Map.Entry<String, List<Product>> entry : productsMap.entrySet()) {
            for (Product product : entry.getValue()) {
                if (product != null) {
                    System.out.println(product.toString());
                    totalItems++;
                    if (product.isSpecial()) {
                        specialProduct++;
                    }
                }
            }
        }

        System.out.println("Итого товаров: " + totalItems);
        System.out.println("Общая стоимость: <" + totalCostBasket() + ">");
        System.out.println("Специальных товаров: <" + specialProduct + ">");
    }

    public boolean checkName(Product product) {
        for (List<Product> productList : productsMap.values()) {
            if (productList.contains(product)) {
                System.out.println("Есть " + product);
                return true;
            }
        }
        System.out.println("Нет " + product);
        return false;
    }





//    public void emptyingTheBasket() {
//
//        for (int i = 0; i < products.length; i++) {
//            if (products[i] != null) {
//                products[i] = null;
//            }
//        }
//    }

    }
