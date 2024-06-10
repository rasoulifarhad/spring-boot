package com.farhad.example.dddorderexample.application.dto;

import lombok.Value;

@Value
public class ShippingAddressDto {
    
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private String label;

}
