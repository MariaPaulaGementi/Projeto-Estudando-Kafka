package com.valdir.demo.model;

import lombok.Getter;

@Getter
public class Payment {

    private Long id;
    private Long idUser;
    private Long idProduct;
    private String cardNumber;


}
