package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasketFull;
import org.skypro.skyshop.basket.ProductBasketEmpty;

import java.util.Arrays;


public class App {
    public static void main(String[] args) {

        ProductBasketEmpty.printBasket();

        System.out.println();
        System.out.println("Примеры с полной корзиной:");
        ProductBasketFull.addToBasket(grape);
        ProductBasketFull.addToBasket(banana);
        ProductBasketFull.addToBasket(orange);
        ProductBasketFull.addToBasket(apple);
        ProductBasketFull.addToBasket(apple);
        ProductBasketFull.addToBasket(apple);
        System.out.println("3 содержимое корзины: ");
        ProductBasketFull.totalCostBasket();
        ProductBasketFull.printBasket();

        System.out.println();
        System.out.println(Arrays.toString(ProductBasketFull.basket));

        System.out.println("4. Проверка по имени :");
        ProductBasketFull.checkName(kiwi);

        System.out.println("5. Метод очистки корзины :");
        ProductBasketFull.emptyingTheBasket();

        System.out.println(Arrays.toString(ProductBasketFull.basket));
    }


    private static Product banana = new Product("Бананы", 100);
    private static Product orange = new Product("Апельсины", 70);
    private static Product apple = new Product("Яблоко", 90);
    private static Product kiwi = new Product("Киви", 120);
    private static Product grape = new Product("Виноград", 150);


    private Product[] products = {banana, orange, kiwi, apple, grape};


}