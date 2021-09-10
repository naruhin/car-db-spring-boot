package com.naruhin.springbootexamplehillelhw5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    private String country;

    private String city;

    private String street;

    private Long zipCode;
}
