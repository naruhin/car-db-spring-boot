package com.naruhin.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ManufacturerDTO {

    private String name;

    private AddressDTO address;
}
