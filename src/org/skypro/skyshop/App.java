package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;
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

        Article article1 = new Article( "article1Name", "article1Text");
        Article article2 = new Article( "article2Name", "article2Text");
        Article article3 = new Article( "article3Name", "article3Text");
        Article article4 = new Article( "article4Name", "article4Text");


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


    }


    private static SimpleProduct banana = new SimpleProduct("Бананы", 100);

    private static FixPriceProduct orange = new FixPriceProduct("Апельсины");
    private static DiscountedProduct apple = new DiscountedProduct("Яблоко", 110, 10);
    private static SimpleProduct kiwi = new SimpleProduct("Киви", 120);
    private static SimpleProduct grape = new SimpleProduct("Виноград", 150);





}