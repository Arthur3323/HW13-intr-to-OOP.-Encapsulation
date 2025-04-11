package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private int basePrice;
    private int percentDiscount;

    public DiscountedProduct (String productName,int basePrice,int percentDiscount) {
        super(productName);
        this.basePrice = basePrice;
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
    public String searchName() {
        return "";
    }

    @Override
    public String getStringRepresentation() {
        return super.getStringRepresentation();
    }
}
