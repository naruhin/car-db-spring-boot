package com.naruhin.springbootexamplehillelhw5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ManufacturerDTO {

    private String name;

    private AddressDTO address;
}
