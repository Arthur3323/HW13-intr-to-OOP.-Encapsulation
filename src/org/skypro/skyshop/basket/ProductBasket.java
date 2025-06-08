package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Collectors;


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
        return productsMap.values().stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printBasket() {
        if (productsMap.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        List<Product> allProducts = productsMap.values().stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        allProducts.forEach(product -> System.out.println(product));

        System.out.println("Итого товаров: " + allProducts.size());
        System.out.println("Общая стоимость: <" + totalCostBasket() + ">");
        System.out.println("Специальных товаров: <" + getSpecialCount() + ">");

    }

    private long getSpecialCount() {
        return productsMap.values().stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .filter(Product::isSpecial)
                .count();
    }

    public boolean checkName(Product product) {
        boolean found = productsMap.values().stream()
                .flatMap(Collection::stream)                        // Поток всех продуктов
                .anyMatch(p -> p.equals(product));                  // Проверка, есть ли такой продукт

        if (found) {
            System.out.println("Есть " + product);
        } else {
            System.out.println("Нет " + product);
        }

        return found;
    }

}
