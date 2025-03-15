package org.skypro.skyshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.interfaces.Searchable;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.searchengine.SearchResult;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)

public class SearchServiceTest {

    @Mock
    private StorageService storageService;
    @InjectMocks
    private SearchService searchService;

    @Test
    public void givenEmptyStorageService_whenCheckSearchService_thenReturnEmptyResult() {

        Mockito.when ( storageService.getAllStorage () ).thenReturn ( new LinkedList<> () );

        boolean result = searchService.search ( "query" ).isEmpty ();

        Assertions.assertTrue ( result );

    }

    @Test
    public void givenStorageServiceWithAnotherObjects_whenCheckSearchService_thenReturnNotFoundResult() {

        Product juice = new SimpleProduct ( "Сок", 150, UUID.randomUUID () );
        Product banana = new FixPriceProduct ( "Банан", UUID.randomUUID () );
        Product wine = new DiscountedProduct ( "Вино", 450, 25, UUID.randomUUID () );
        Article articleAboutApple = new Article ( UUID.randomUUID (), "Статья про яблоки", "Яблоко от яблони не далеко падает" );
        List<Searchable> list = List.of ( banana, wine, juice, articleAboutApple );

        Mockito.when ( storageService.getAllStorage () ).thenReturn ( list );

        boolean result = searchService.search ( "Арбуз" ).isEmpty ();

        Assertions.assertTrue ( result );

    }

    @Test
    public void givenStorageServiceWithCorrectObject_whenCheckSearchService_thenReturnFoundResult() {

        Product juice = new SimpleProduct ( "Сок", 150, UUID.randomUUID () );
        Product banana = new FixPriceProduct ( "Банан", UUID.randomUUID () );
        Product wine = new DiscountedProduct ( "Вино", 450, 25, UUID.randomUUID () );
        SimpleProduct apple = new SimpleProduct ( "Яблоко", 500, UUID.randomUUID () );
        Article articleAboutApple = new Article ( UUID.randomUUID (), "Статья про яблоки", "Яблоко от яблони не далеко падает" );
        List<Searchable> list = List.of ( banana, wine, juice, articleAboutApple, apple );

        Mockito.when ( storageService.getAllStorage () ).thenReturn ( list );

        assertThat ( searchService.search ( "Сок" ).stream ().map ( SearchResult::getId ) )
                .hasSize ( 1 )
                .containsOnly ( SearchResult.fromSearchable ( juice ).getId () );

    }
}
