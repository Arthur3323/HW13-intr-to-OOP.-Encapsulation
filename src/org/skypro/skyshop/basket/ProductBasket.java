package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class ProductBasket {
    private List<Product> products = new LinkedList<>();

    public void addToBasket(Product product) {
        products.add(product);
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }
        return removedProducts;
    }

    public int totalCostBasket() {
        int sum = 0;

        for (Product element : products) {
            if (element != null)
                sum += element.getPrice();
        }
        return sum;
    }

    public void printBasket() {

        if (totalCostBasket() == 0) {
            System.out.println("в корзине пусто");
            return;
        }

        int specialProduct = 0;
        for (Product element : products) {
            if (element != null) {
                System.out.println(element.toString());
                if (element.isSpecial()) {
                    specialProduct ++;
                }
            }
        }

        System.out.println("Итого: <" + totalCostBasket() + ">");
        System.out.println("Специальных товаров: <" + specialProduct + ">");
    }

    public boolean checkName(Product product) {
      for  (Product element: products) {
            if ( element == product) {
                System.out.println("есть " + product);
                return true;
            }

        }  System.out.println("Нет " + product);
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
