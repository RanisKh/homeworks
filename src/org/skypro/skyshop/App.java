package org.skypro.skyshop;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket(5);

        Product butter = new FixPriceProduct("Масло");
        Product fish = new FixPriceProduct("Треска");
        Product meat = new DiscountedProduct("Баранина", 700, 30 );
        Product rise = new SimpleProduct("Рис", 100);
        Product bread = new SimpleProduct("Хлеб", 55);
        Product meat2 = new DiscountedProduct("Говядина", 500, 10);

        productBasket.addProduct(butter);
        productBasket.addProduct(fish);
        productBasket.addProduct(meat2);
        productBasket.addProduct(rise);
        productBasket.addProduct(bread);
        productBasket.addProduct(meat);

        System.out.println("Корзина: ");
        productBasket.printProductBasket();

        System.out.println("Есть ли рыба в корзине " + productBasket.hasProduct("", "Рыба"));
        System.out.println("Есть ли баранина в корзине " + productBasket.hasProduct("", "Баранина"));

        productBasket.clearBasket();
        productBasket.printProductBasket();
    }
}