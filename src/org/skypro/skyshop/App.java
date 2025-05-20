package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SearchEngine.BestResultNotFound;
import org.skypro.skyshop.product.SearchEngine.SearchEngine;


import java.util.List;


public class App {
    public static void main(String[] args) {

        System.out.println("1. Изменение используемой структуры данных в классе ProductBacket:");
        ProductBasket testBasket = new ProductBasket();
        testBasket.printBasket();

        testBasket.addToBasket(apple);
        testBasket.addToBasket(banana);
        testBasket.addToBasket(orange);
        testBasket.addToBasket(grape);
        testBasket.addToBasket(apple);
        System.out.println("Cодержимое корзины: ");

        testBasket.printBasket();

        System.out.println("Проверка по имени :");

        testBasket.checkName(kiwi);
        testBasket.checkName(apple);

        System.out.println("\n2. Добавление метода удаления продукта по имени из корзины: ");

        System.out.println("2.1 Удалить существующий продукт из корзины:");
        List<Product> removed = testBasket.removeProductsByName("Яблоко");
        System.out.println("Удаленные продукты:");
        for (Product p : removed) {
            System.out.println(p.getProductName());
        }
        testBasket.printBasket();

        System.out.println("2.4 Удалить несуществующий продукт:");
        List<Product> notExist = testBasket.removeProductsByName("Хурма");
        if (notExist.isEmpty()) {
            System.out.println("Список пуст");
        }
        testBasket.printBasket();




        System.out.println("\n3. Изменение используемой структуры данных в классе SearchEngine: ");
        Article article1 = new Article("Роберт Мартин - Чистый код", "Это книга о принципах и практиках написания читабельного и поддерживаемого кода");
        Article article2 = new Article("Эрих Гамма - Паттерны проектирования", "Это как рецепты или стратегии для написания кода под разные задачи");
        Article article3 = new Article("Кэти Сьерра - Изучаем Java", "Книга от издательства O'Relly поможет изучить основы Java: переменные, типы данных, условные операторы, циклы и другие ключевые концепции");
        Article article4 = new Article("Герберт Шилдт- Java. Полное руководство", "В книге рассказывается об основах языка — синтаксисе и переменных, и о более сложных темах — многопоточности и сетевых соединениях");


        SearchEngine searchEngine = new SearchEngine(10);


        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);

        List<Searchable> searchResults = searchEngine.search("код");
        System.out.println("Все совпадения:");
        for (Searchable result : searchResults) {
            if (result == null) continue;
            System.out.println(result.getStringRepresentation());
        }

        System.out.println("\nПредыдущие задания: \nexceptions:");

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
            DiscountedProduct belowDiscountProduct = new DiscountedProduct("Курага", 80, -10);
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