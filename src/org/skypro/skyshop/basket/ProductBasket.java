package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;


public class ProductBasket {

    public static Product[] basket = new Product[5];

    public void addToBasket(Product Product) {
        int i = 0;
        for (Product element : basket) {
            if (element == null) {
                basket[i] = Product;
                return;
            }
            i += 1;
            if (i == 5) {
                System.out.println("Невозможно добавить продукт");
                System.out.println();
                return;
            }
        }
    }

    public int totalCostBasket() {
        int sum = 0;

        for (Product element : basket) {
            if (element != null)
                sum += element.getPrice();
        }
        return sum;
    }

    public void printBasket() {

        String productName;
        int price;
        for (Product element : basket) {
            if (element != null) {

                productName = element.getProductName();
                price = element.getPrice();
                System.out.println("<" + productName + "> : <" + price + ">");
            }
        }
        if (totalCostBasket() == 0) {
            System.out.println("в корзине пусто");
            return;
        }

        System.out.println("Итого: <" + totalCostBasket() + ">");
    }

    public boolean checkName(Product product) {

      for  (Product element: basket) {
            if ( element == product) {
                System.out.println("есть такой");
                return true;
            }

        }  System.out.println("Такого нет");
      return false;
    }


    public void emptyingTheBasket() {

        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                basket[i] = null;
            }

        }


    }
}