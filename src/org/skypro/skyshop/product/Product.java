package org.skypro.skyshop.product;

public abstract class Product implements Searchable{
    private String productName;


    public Product(String productName) {
        this.productName = productName;

    }

    public String getProductName() {
        return productName;
    }



    public abstract int getPrice();


    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + getPrice() +
                '}';
    }

   public abstract boolean isSpecial();

    @Override
    public String searchTerm () {
        return toString();
    }


    @Override
    public String searchType () {
        return "PRODUCT";
    }

 }


