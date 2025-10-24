package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class ProductBasket {
    private List<Product> products;

    public ProductBasket() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (product != null) {
            products.add(product);
        }
    }

    public void removeProduct(String product) {
        if (product != null) {
            products.remove(product);
        }
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (Product product : products) {
            total+= product.getPrice();
            }
        return total;
    }

    public List<Product> removeAllProductsByName(String name) {
        List<Product> removedProducts = new ArrayList<>();

        if (name == null || name.trim().isEmpty()) {
            return removedProducts;
        }

        String searchName = name.trim().toLowerCase();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().toLowerCase().equals(searchName)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }

        return removedProducts;
    }

    public int printProductBasket() {
        int specialCount = 0;
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getName() + " : " + product.getPrice());
            }
            System.out.println("Итого " + getTotalPrice());
        }
        if (products == null){
            return 0;
        }
        for (Product product : products) {
            if (product.isSpecial()) {
                specialCount++;
            }
            return specialCount;
        }
        return specialCount;
    }


    public boolean hasProduct(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        products.clear();
    }


    @Override
    public String toString() {
        if (products.isEmpty()){
            System.out.println("Корзина пуста");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Содержимое корзины:");
        for (Product product : products){
            sb.append("- ").append(product.getName())
                    .append(": ").append(product.getPrice()).append(" руб.");
        }
        sb.append("Общая стоимость: ").append(getTotalPrice()).append(" руб.");
        return sb.toString();
    }

}