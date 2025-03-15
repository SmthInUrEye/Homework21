package org.skypro.skyshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.exeptions.NoSuchProductExeption;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.service.BasketService;
import org.skypro.skyshop.service.StorageService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class BasketServiceTest {

    private ProductBasket productBasketMock;

    private StorageService storageServiceMock;

    private BasketService basketService;

    @BeforeEach
    void setUp() {
        productBasketMock = mock ( ProductBasket.class );
        storageServiceMock = mock ( StorageService.class );
        basketService = new BasketService ( productBasketMock, storageServiceMock );
    }

    @Test
    public void givenStorageServiceWithObjects_whenTryToAddNotExistingObject_thenThrowException() {

        UUID productId = UUID.randomUUID ();

        Mockito.when ( storageServiceMock.getProductById ( productId ) ).thenReturn ( Optional.empty () );

        assertThrows ( NoSuchProductExeption.class, () -> basketService.addProduct ( productId ) );

    }

    @Test
    public void givenStorageServiceWithExistingObject_whenTryToAddExistingObject_thenVerifyAddMethodCall() {

        Product juice = new SimpleProduct ( "Сок", 150, UUID.randomUUID () );
        Mockito.when ( storageServiceMock.getProductById ( juice.getId () ) ).thenReturn ( Optional.of ( juice ) );

        basketService.addProduct ( juice.getId () );

        verify ( productBasketMock ).add ( juice.getId () );
    }


    @Test
    public void givenEmptyProductBasket_whenTryToGetUserBasket_thenReturnEmptyBasket() {

        when ( productBasketMock.getProductsInBasket () ).thenReturn ( Collections.EMPTY_MAP );

        UserBasket userBasket = basketService.getUserBasket ();

        assertTrue ( userBasket.getUserProductList ().isEmpty () );

    }

    @Captor
    private ArgumentCaptor<UUID> productCaptor;

    @Test
    public void givenProductBasketWithProducts_whenTryToGetUserBasket_thenReturnUserBasket() {

        Product product = new SimpleProduct ( "Сок", 150, UUID.randomUUID () );
        when ( storageServiceMock.getProductById ( product.getId () ) ).thenReturn ( Optional.of ( product ) );
        doNothing ().when ( productBasketMock ).add ( productCaptor.capture () );

        basketService.addProduct ( product.getId () );

        verify ( productBasketMock, times ( 1 ) ).add ( product.getId () );
        assertEquals ( product.getId (), productCaptor.getValue () );

    }
}
