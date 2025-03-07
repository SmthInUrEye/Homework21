package org.skypro.skyshop.model.exeptions;

public class NoSuchProductExeption extends RuntimeException {

    public NoSuchProductExeption() {
        super ("Продукт не найден");
    }
}

