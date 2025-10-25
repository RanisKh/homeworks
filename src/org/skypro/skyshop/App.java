package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.search.SearchEngine;
import org.skypro.skyshop.product.search.Searchable;

import java.util.List;
import java.util.Map;
import java.util.Set;


public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

        Product butter = new FixPriceProduct("Масло");
        Product fish = new FixPriceProduct("Треска");
        Product meat = new DiscountedProduct("Баранина", 700, 30);
        Product rise = new SimpleProduct("Рис", 100);
        Product bread = new SimpleProduct("Хлеб", 55);
        Product meat2 = new DiscountedProduct("Говядина", 500, 10);

        Article article1 = new Article("Хлеб", "Хлеб российский");
        Article article2 = new Article("Рис", "Отборный рис из Китая");

        SearchEngine.add(new SimpleProduct("Хлеб", 55));
        SearchEngine.add(new FixPriceProduct("Треска"));
        SearchEngine.add(new DiscountedProduct("Баранина", 700, 30));
        SearchEngine.add(new SimpleProduct("Рис", 55));
        SearchEngine.add(new FixPriceProduct("Масло"));

        System.out.println("Test SimpleProduct");
        testSimpleProduct();

        System.out.println("Test DiscountedProduct");
        testDiscountedProduct();

        productBasket.addProduct(butter);
        productBasket.addProduct(fish);
        productBasket.addProduct(meat2);
        productBasket.addProduct(rise);
        productBasket.addProduct(bread);
        productBasket.addProduct(meat);

        productBasket.printProductBasket();

        productBasket.getTotalPrice();

        productBasket.hasProduct("Треска");
        productBasket.hasProduct("Виноград");

        Set<Searchable> breadResults = SearchEngine.search("Хлеб");
        printResult((List<Searchable>) breadResults);


        productBasket.removeAllProductsByName("Баранина");
        productBasket.removeProduct(bread);
        productBasket.clearBasket();
        productBasket.printProductBasket();
        List<Product> removedButter = productBasket.removeAllProductsByName("масло");
        System.out.println("removed products:");
        if (removedButter.isEmpty()) {
            System.out.println("List is empty");
        } else {
            for (Product product : removedButter) {
                System.out.println(" - " + product.getName() + ": " + product.getPrice() + "rub.");
            }
        }
        List<Product> removePens = productBasket.removeAllProductsByName("");
        System.out.println("Removed products: ");
        if (removePens.isEmpty()) {
            System.out.println("List is empty");
        } else {
            for (Product product : removePens) {
                System.out.println(" - " + product.getName() + ": " + product.getPrice() + "rub.");
            }
        }

    }

    private static void printResult(List<Searchable> results) {
        if (results.isEmpty()) {
            System.out.println("Not found!");
            return;
        }

        System.out.println("Found " + results.size() + "objects: ");
        SearchEngine.getSearchables().forEach(item ->
                System.out.println(item.getStringRepresentation()));
    }

    private static void testSimpleProduct() {
        try {
            SimpleProduct product1 = new SimpleProduct("Яблоки Голден", 0.0);
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR : " + e.getMessage());
        }

        try {
            SimpleProduct product2 = new SimpleProduct(" ", 50.0);
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR : " + e.getMessage());
        }
    }

    private static void testDiscountedProduct() {
        try {
            DiscountedProduct product3 = new DiscountedProduct("Апельсины", 500.0, -5.0);
        } catch (IllegalArgumentException e) {
            System.out.println("ОШИБКА: " + e.getMessage());
        }

        try {
            DiscountedProduct product4 = new DiscountedProduct("Бананы", 0.0, 10.0);
        } catch (IllegalArgumentException e) {
            System.out.println("ОШИБКА: " + e.getMessage());

        }
    }
}

