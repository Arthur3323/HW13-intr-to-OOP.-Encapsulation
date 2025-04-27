package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SearchEngine.BestResultNotFound;
import org.skypro.skyshop.product.SearchEngine.SearchEngine;

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
        System.out.println("Intreface:");

        Article article1 = new Article("article1Name", "article1Text");
        Article article2 = new Article("article2Name", "article2Text");
        Article article3 = new Article("article3Name", "article3Text");
        Article article4 = new Article("article4Name", "article4Text");


        SearchEngine searchEngine = new SearchEngine(10);


        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);

        Searchable[] searchResults = searchEngine.search("ARTICLE");
        for (Searchable result : searchResults) {
            if (result == null) continue;
            System.out.println(result.getStringRepresentation());
        }

        System.out.println("exceptions:");

        try {
            SimpleProduct nullProduct = new SimpleProduct("", 150);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка 1: " + e.getMessage());
        }

        try {
            SimpleProduct emptyProduct = new SimpleProduct("   ", 150);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка 2: " + e.getMessage());
        }

        try {
            DiscountedProduct negativePriceProduct = new DiscountedProduct("Персик", -100, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка 3: " + e.getMessage());
        }

        try {
            DiscountedProduct overDiscountProduct = new DiscountedProduct("Мандарин", 80, 110);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка 4: " + e.getMessage());
        }

        try {
            DiscountedProduct belowВiscountProduct = new DiscountedProduct("Курага", 80, -10);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка 5: " + e.getMessage());
        }

        System.out.println("exceptions, проверка успешного создания:");

        try {
            DiscountedProduct raisin = new DiscountedProduct("Изюм", 150, 10);
            System.out.println("Продукт со скидкой успешно создан: " + raisin.getProductName());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка 6: " + e.getMessage());
        }

        try {
            SimpleProduct jam = new SimpleProduct("Варенье", 10);
            System.out.println("Простой продукт успешно создан: " + jam.getProductName());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка 6: " + e.getMessage());
        }

        System.out.println("Демонстрация нового метода поиска:");
        SearchEngine engine = new SearchEngine(3);

        engine.add(new Article("greeting", "hello"));
        engine.add(new Article("greeting hello hello x 2 ", "hello hello"));
        engine.add(new Article("greeting!!!", "hello! hello! hello!"));


        try {
            Searchable result = engine.findBestMatch("hello");
            System.out.println("Найден лучший результат: " + result.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Searchable result = engine.findBestMatch("   ");
            System.out.println("Найден лучший результат: " + result.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Searchable result = engine.findBestMatch("Помидор");
            System.out.println("Найден лучший результат: " + result.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

    }


    private static SimpleProduct banana = new SimpleProduct("Бананы", 100);

    private static FixPriceProduct orange = new FixPriceProduct("Апельсины");
    private static DiscountedProduct apple = new DiscountedProduct("Яблоко", 110, 10);
    private static SimpleProduct kiwi = new SimpleProduct("Киви", 120);
    private static SimpleProduct grape = new SimpleProduct("Виноград", 150);


}