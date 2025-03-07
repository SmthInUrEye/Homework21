package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.product.Product;

public class BasketItem {

    private final Product item;
    private final int itemQTY;

    public BasketItem(Product item, int itemQTY) {
        this.item = item;
        this.itemQTY = itemQTY;
    }

    public Product getItem() {
        return item;
    }

    public int getItemQTY() {
        return itemQTY;
    }
}
