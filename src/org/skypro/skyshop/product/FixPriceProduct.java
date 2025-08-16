package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIX_PRICE = 99;

    public FixPriceProduct(String product) {
        super(product);
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "Продукт с фиксированной ценой: " + name + " стоимость " + FIX_PRICE;
    }
}
