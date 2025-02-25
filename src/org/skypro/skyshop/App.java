package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

import java.util.Arrays;


public class App {
    public static void main(String[] args) {

        ProductBasket.printBasket();

        System.out.println();
        System.out.println("Примеры с полной корзиной:");
        ProductBasket.addToBasket(grape);
        ProductBasket.addToBasket(banana);
        ProductBasket.addToBasket(orange);
        ProductBasket.addToBasket(apple);
        ProductBasket.addToBasket(apple);
        ProductBasket.addToBasket(apple);
        System.out.println("3 содержимое корзины: ");
        ProductBasket.totalCostBasket();
        ProductBasket.printBasket();

        System.out.println();
        System.out.println(Arrays.toString(ProductBasket.basket));

        System.out.println("4. Проверка по имени :");
        ProductBasket.checkName(kiwi);

        System.out.println("5. Метод очистки корзины :");
        ProductBasket.emptyingTheBasket();

        System.out.println(Arrays.toString(ProductBasket.basket));
    }


    private static Product banana = new Product("Бананы", 100);
    private static Product orange = new Product("Апельсины", 70);
    private static Product apple = new Product("Яблоко", 90);
    private static Product kiwi = new Product("Киви", 120);
    private static Product grape = new Product("Виноград", 150);


    private Product[] products = {banana, orange, kiwi, apple, grape};


}