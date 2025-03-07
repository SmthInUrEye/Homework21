package org.skypro.skyshop.model.product;

import java.util.UUID;

public class FixPriceProduct extends Product {
    private static final int FIXED_VALUE = 75;
    private final UUID id;

    public FixPriceProduct(String productName, UUID id) {
        super ( productName );
        this.id = id;
    }

    @Override
    public int getPrice() {
        return FIXED_VALUE;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        return (getProductName () + ": Фиксированная цена " + getPrice ());
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
