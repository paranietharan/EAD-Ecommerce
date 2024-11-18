package com.teamz.customer.entity;


import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String houseNo;
    private String street;
    private String city;
    private String district;
    private String province;
    private Long postalCode;
}
