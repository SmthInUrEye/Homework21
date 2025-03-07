package org.skypro.skyshop.model.basket;

import java.util.List;

public class UserBasket {
    private final List<BasketItem> userProductList;
    private final int total;

    public UserBasket(List<BasketItem> userProductList) {
        this.userProductList = userProductList;
        this.total = userProductList
                .stream ()
                .mapToInt ( basketItem -> basketItem.getItemQTY () * basketItem.getItem ().getPrice () )
                .sum ();
    }

    public int getTotal() {
        return total;
    }

    public List<BasketItem> getUserProductList() {
        return userProductList;
    }

}
