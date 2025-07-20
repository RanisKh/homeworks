package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

public class APP {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket(5);

        Product butter = new Product("Масло", 70);
        Product fish = new Product("Треска", 150);
        Product meat = new Product("Баранина", 700);
        Product rise = new Product("Рис", 100);
        Product bread = new Product("Хлеб", 55);
        Product meat2 = new Product("Говядина", 500);

        productBasket.addProduct(butter);
        productBasket.addProduct(fish);
        productBasket.addProduct(meat2);
        productBasket.addProduct(rise);
        productBasket.addProduct(bread);
        productBasket.addProduct(meat);

        System.out.println("Basket: ");
        productBasket.printProductBasket();

        System.out.println("Есть ли рыба в корзине " + productBasket.hasProduct("", "Рыба"));
        System.out.println("Есть ли баранина в корзине " + productBasket.hasProduct("", "Баранина"));

        productBasket.clearBasket();
        productBasket.printProductBasket();
    }
}