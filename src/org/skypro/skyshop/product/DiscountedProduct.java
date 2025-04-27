package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private int basePrice;
    private int percentDiscount;

    public DiscountedProduct (String productName,int basePrice,int percentDiscount) {
        super(productName);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("цена должна быть строго больше 0");
        }
        this.basePrice = basePrice;

        if ( percentDiscount < 0  || percentDiscount > 100) {
            throw new IllegalArgumentException("процент должен быть числом в диапазоне от 0 до 100 включительно");
        }
        this.percentDiscount = percentDiscount;
    }

    @Override
    public int getPrice() {
        return basePrice - (basePrice * percentDiscount/100);
    }

    @Override
    public String toString() {
            return "<" + getProductName() + ">: "
                    +  "<" + getPrice() + "> " +
                    "(<" + percentDiscount + ">%)";
        }

    @Override
    public boolean isSpecial() {
        return true;
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
