package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    double price;


    public SimpleProduct(String product, double price) {
        super(product);
        this.price = price;

        if (price <= 0) {
            throw new IllegalArgumentException("Цена продукта должна быть строго больше 0");
        }

    }


    @Override
    public double getPrice() {
        return price;
    }

    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return "Продукт: " + name + "стоимость " + price;
    }


    @Override
    public String getStringRepresentation() {
        return super.getStringRepresentation();
    }
}