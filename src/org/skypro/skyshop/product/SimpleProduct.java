package org.skypro.skyshop.product;

public class SimpleProduct extends Product {


    private int price;

    public SimpleProduct (String productName, int price) {
        super(productName);
        if (price <= 0) {
            throw new IllegalArgumentException("цена должна быть строго больше 0");
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "<" + getProductName() + ">: "
                +  "<" + price + ">" ;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String getSearchName() {
        return "";
    }

    @Override
    public String getStringRepresentation() {
        return super.getStringRepresentation();
    }
}
