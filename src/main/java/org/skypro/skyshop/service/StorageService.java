package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.interfaces.Searchable;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {

    private final Map<UUID, Product> productStorage;
    private final Map<UUID, Article> articleStorage;

    private void fillProductStorage() {

        SimpleProduct apple = new SimpleProduct ( "Яблоко", 500, UUID.randomUUID () );
        SimpleProduct orange = new SimpleProduct ( "Апельсин", 100, UUID.randomUUID () );
        SimpleProduct milk = new SimpleProduct ( "Молоко", 200, UUID.randomUUID () );
        Product juice = new SimpleProduct ( "Сок", 150, UUID.randomUUID () );
        Product water = new SimpleProduct ( "Вода", 50, UUID.randomUUID () );
        Product banana = new FixPriceProduct ( "Банан", UUID.randomUUID () );
        Product wine = new DiscountedProduct ( "Вино", 450, 25, UUID.randomUUID () );

        productStorage.put ( apple.getId (), apple );
        productStorage.put ( orange.getId (), orange );
        productStorage.put ( milk.getId (), milk );
        productStorage.put ( juice.getId (), juice );
        productStorage.put ( water.getId (), water );
        productStorage.put ( banana.getId (), banana );
        productStorage.put ( wine.getId (), wine );

    }

    private void fillArticleStorage() {

        Article articleAboutBanana = new Article ( UUID.randomUUID (), "Статья про бананы", "Бананы очень полезны для организма. Растут на деревьях" );
        Article articleAboutApple = new Article ( UUID.randomUUID (), "Статья про яблоки", "Яблоко от яблони не далеко падает" );
        Article articleAboutHealth = new Article ( UUID.randomUUID (), "Статья про здоровье", "Яблоко помогает держать тонус и баланс физических сил человека" );

        articleStorage.put ( articleAboutApple.getId (), articleAboutApple );
        articleStorage.put ( articleAboutHealth.getId (), articleAboutHealth );
        articleStorage.put ( articleAboutBanana.getId (), articleAboutBanana );

    }

    public StorageService(Map<UUID, Product> productStorage, Map<UUID, Article> articleStorage) {

        this.productStorage = productStorage;
        this.articleStorage = articleStorage;

        fillProductStorage ();
        fillArticleStorage ();

    }

    public Collection<Article> getAllArticles() {
        return articleStorage.values ();
    }

    public Collection<Product> getAllProducts() {
        return productStorage.values ();
    }

    public Collection<Searchable> getAllStorage() {

        Collection<Searchable> allSearchableItems = new LinkedList<> ();

        allSearchableItems.addAll ( articleStorage.values () );
        allSearchableItems.addAll ( productStorage.values () );

        return allSearchableItems;

    }

    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable ( productStorage.get ( id ) );
    }
}
