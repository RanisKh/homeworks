package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    public static final double fixPrice = 99;

    public FixPriceProduct(String product) {
        super(product);
    }

    @Override
    public double getPrice() {
        return fixPrice;
    }

    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "Продукция с фиксированной ценой" +
                "name='" + name + '\'' +
                fixPrice;
    }


    @Override
    public String getStringRepresentation() {
        return super.getStringRepresentation();
    }
}
