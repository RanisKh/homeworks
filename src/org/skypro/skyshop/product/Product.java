package org.skypro.skyshop.product;

public abstract class Product {
    public String name;


    public Product(String product) {
        this.name = product;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public boolean isSpecial() {
        return true;
    }
}
