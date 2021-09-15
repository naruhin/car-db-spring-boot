package com.naruhin.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServiceStationDTO {

    private String name;

    private AddressDTO address;
}
