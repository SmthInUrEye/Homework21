package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SimpleProduct extends Product {

    private final int productValue;
    private final UUID id;

    public SimpleProduct(String productName, int productValue, UUID id) {
        super ( productName );
        this.id = id;
        checkSimpleProductPrice ( productValue );
        this.productValue = productValue;
    }

    public static void checkSimpleProductPrice(int productValue) {
        if ( productValue < 0 ) throw new IllegalArgumentException ( "Цена должна быть больше 0" );
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public int getPrice() {
        return productValue;
    }

    @Override
    public String toString() {
        return (getProductName () + ": " + getPrice ());
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public UUID getId() {
        return id;
    }

}