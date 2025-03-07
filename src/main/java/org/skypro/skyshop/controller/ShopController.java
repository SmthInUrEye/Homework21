package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.searchengine.SearchResult;
import org.skypro.skyshop.service.BasketService;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.UUID;

@RestController
public class ShopController {

    private final StorageService storageService;
    private final SearchService searchService;
    private final BasketService basketService;

    @Autowired
    public ShopController(StorageService storageService, SearchService searchService, BasketService basketService) {
        this.storageService = storageService;
        this.searchService = searchService;
        this.basketService = basketService;
    }

    @GetMapping("/products")
    public Collection<Product> getAllProducts() {
        return storageService.getAllProducts ();
    }

    @GetMapping("/articles")
    public Collection<Article> getAllArticles() {
        return storageService.getAllArticles ();
    }

    @GetMapping("/search")
    public Collection<SearchResult> getSearch(@RequestParam String pattern) {
        return searchService.search ( pattern );
    }

    @GetMapping("/basket/{id}")
    public ResponseEntity<String> addProduct(@PathVariable("id") UUID id) {
        basketService.addProduct ( id );
        return ResponseEntity.ok ("Продукт успешно добавлен");
    }

    @GetMapping("/basket")
    public UserBasket getUserBasket() {
        return (basketService.getUserBasket ());
    }

}
