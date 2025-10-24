package org.skypro.skyshop.product;


import org.skypro.skyshop.product.search.Searchable;

public abstract class Product implements Searchable {
    public String name;


    public Product(String product) {
        validateName(name);
        this.name = product;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть null, пустой строкой или состоять только из пробелов");
        }
    }

    public String getName() {
        return name;
    }

    public abstract double getPrice();

    public boolean isSpecial() {
        return true;
    }

    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

}