package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    double basePrice;
    double discountInPercentages;

    public DiscountedProduct(String product, double basePrice, double discountInPercentages) {
        super(product);
        validateBasePrice(basePrice);
        validateDiscountPercentages();
        this.basePrice = basePrice;
        this.discountInPercentages = discountInPercentages;
    }

    private void validateBasePrice(double basePrice) {
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Базовая цена продукта должна быть строго больше 0. Передано: " + basePrice);
        }
    }

    private void validateDiscountPercentages() {
        if (discountInPercentages < 0 || discountInPercentages > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть в диапазоне от 0 до 100 включительно. Передано: " + discountInPercentages);
        }
    }

    public double getDiscountInPercentages() {
        return basePrice - (basePrice / 100 * discountInPercentages);
    }

    @Override
    public double getPrice() {
        return basePrice;
    }

    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "Скидочный продут: " + name + ", стоимость=" + basePrice +
                "скидка" + discountInPercentages;
    }


    @Override
    public String getStringRepresentation() {
        return super.getStringRepresentation();
    }
}