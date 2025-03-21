package org.skypro.skyshop;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Arrays;


public class App {
    public static void main(String[] args) {


        ProductBasket testBasket = new ProductBasket();
        testBasket.printBasket();

        System.out.println();
        System.out.println("Примеры с полной корзиной:");


        testBasket.addToBasket(apple);
        testBasket.addToBasket(banana);
        testBasket.addToBasket(orange);
        testBasket.addToBasket(grape);
        testBasket.addToBasket(apple);
        testBasket.addToBasket(apple);
        System.out.println("3 содержимое корзины: ");
        testBasket.totalCostBasket();
        testBasket.printBasket();

        System.out.println();
        System.out.println(Arrays.toString(ProductBasket.basket));

        System.out.println("4. Проверка по имени :");

        testBasket.checkName(kiwi);

        System.out.println("5. Метод очистки корзины :");
        testBasket.emptyingTheBasket();
        System.out.println(Arrays.toString(ProductBasket.basket));

    }


    private static SimpleProduct banana = new SimpleProduct("Бананы", 100);
    private static FixPriceProduct orange = new FixPriceProduct("Апельсины");
    private static DiscountedProduct apple = new DiscountedProduct("Яблоко", 110, 10);
    private static SimpleProduct kiwi = new SimpleProduct("Киви", 120);
    private static SimpleProduct grape = new SimpleProduct("Виноград", 150);





}