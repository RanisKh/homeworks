package org.skypro.skyshop.product;

public class SimpleProduct extends Product{
    int price;


    public SimpleProduct(String product, int price) {
        super(product);
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public boolean isSpecial(){
        return false;
    }

    @Override
    public String toString() {
        return "Продукт: "  + name + "стоимость " + price;
    }
}
