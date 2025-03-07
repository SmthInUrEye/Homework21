package org.skypro.skyshop.model.basket;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;


@SessionScope
@Component
public class ProductBasket {

    private final Map<UUID, Integer> productsInBasket;

    public ProductBasket(Map<UUID, Integer> productsInBasket) {
        this.productsInBasket = productsInBasket;
    }

    public void add(UUID id) {
        int productsQTY = 1;
        if ( productsInBasket.containsKey ( id ) ) {
            productsQTY++;
            productsInBasket.replace ( id, productsQTY );
        } else productsInBasket.put ( id, productsQTY );
    }

    public Map<UUID, Integer> getProductsInBasket() {
        return Collections.unmodifiableMap ( productsInBasket );
    }

}
