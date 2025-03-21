package org.skypro.skyshop.product;

public class FixPriceProduct extends Product{

    private static final int FIX_PRICE = 75;

    public FixPriceProduct(String productName) {
        super(productName);

    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return "<" + getProductName() + ">: "
                +  "<Фиксированная цена> " +
                 "<" + getPrice() + "> " ;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
