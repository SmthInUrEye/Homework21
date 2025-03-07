package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.exeptions.NoSuchProductExeption;
import org.skypro.skyshop.model.exeptions.ShopError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShopControllerAdvice {
    @ExceptionHandler(NoSuchProductExeption.class)
    public ResponseEntity <ShopError> handleNoSuchProductExeption (NoSuchProductExeption ex){
        ShopError error = new ShopError ( "404", ex.getMessage () );
        return new ResponseEntity<> ( error, HttpStatus.NOT_FOUND );
    }
}
