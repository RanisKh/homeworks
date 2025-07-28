package org.skypro.skyshop.product;

public class DiscountedProduct extends  Product{
    int basePrice;
    int discountInPercentages ;

    public DiscountedProduct(String product, int basePrice, int discountInPercentages) {
        super(product);
        this.basePrice = basePrice;
        this.discountInPercentages = discountInPercentages;
    }

    public int getDiscountInPercentages() {
        return basePrice - (basePrice/ 100 * discountInPercentages);
    }

    @Override
    public int getPrice() {
        return basePrice;
    }

    public boolean isSpecial(){
        return true;
    }

    @Override
    public String toString() {
        return "Скидочный продут: "  + name +  ", стоимость=" + basePrice +
                "скидка" + discountInPercentages;
    }
}
