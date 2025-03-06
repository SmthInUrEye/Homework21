package org.skypro.skyshop.model.product;

import java.util.UUID;

public class DiscountedProduct extends Product {

    private final int baseValue;
    private final int discount;
    private final UUID id;

    public DiscountedProduct(String productName, int baseValue, int discount, UUID id) {
        super ( productName );
        this.id = id;
        checkDiscountedProductPrice ( baseValue, discount );
        this.baseValue = baseValue;
        this.discount = discount;
    }

    public static void checkDiscountedProductPrice(int baseValue, int discount) {
        if ( baseValue < 0 ) throw new IllegalArgumentException ( "Цена должна быть больше 0" );
        if ( !(discount >= 0 && discount <= 100) )
            throw new IllegalArgumentException ( "Размер скидки должен находиться в диапазоне (0..100)" );
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public int getPrice() {
        return (baseValue - ((baseValue * discount) / 100));
    }

    @Override
    public String toString() {
        return (getProductName () + ": " + getPrice () + "(" + discount + ")");
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public UUID getId() {
        return id;
    }
}
