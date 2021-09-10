package com.naruhin.springbootexamplehillelhw5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServiceStationDTO {

    private String name;

    private AddressDTO address;
}
