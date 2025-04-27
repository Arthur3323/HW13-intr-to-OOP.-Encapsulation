package org.skypro.skyshop.product;

public abstract class Product implements Searchable{
    private String productName;


    public Product(String productName) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустой строкой или null");
        }
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
    public String getSearchTerm() {
        return toString();
    }


    @Override
    public String getSearchType() {
        return "PRODUCT";
    }

 }


