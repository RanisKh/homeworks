package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private final Product[] products;
    private int size;

    public ProductBasket(int basket) {
        products = new Product[basket];
        size = 0;
    }

    public void addProduct(Product product) {
        if (size < products.length) {
            products[size] = product;
            size++;
        } else {
            System.out.println("Корзина заполнена, невозможно добавить продукт");
        }


    }

    public int getTotalPriсe() {
        return 0;
    }


    public void printProductBasket() {
        int specialCount = 0;
        if (size == 0) {
            System.out.println("Корзина полная");
            return;
        }
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getName() + " : " + product.getPrice());
            }
            System.out.println("Итого " + getTotalPriсe());
        }
        for (Product product : products){
            if (product.isSpecial()){
                specialCount ++;
            }
        }
    }

    public boolean hasProduct(String products, String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        Arrays.fill(products, null);
    }



    @Override
    public String toString() {
        return "ProductBasket{" +
                "products=" + Arrays.toString(products) +
                ", size=" + size +
                '}';
    }
}
