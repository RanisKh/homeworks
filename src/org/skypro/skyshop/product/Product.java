package org.skypro.skyshop.product;

public class Product {
    public String name;
    int price;

    public Product(String product, int price) {
        this.name = product;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
