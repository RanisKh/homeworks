package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;
import java.util.List;

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

    private void getPrice() {
    }

    public void printProductBasket() {
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
    }

    public boolean hasProduct(List<Product> products, String name) {
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
}
