package com.naruhin.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarDTO {
    private ManufacturerDTO manufacturer;

    private String model;

    private String color;

    private DealerDTO dealer;

    private ServiceStationDTO serviceStation;

    private String bodyStyle;

    private EngineDTO engine;
}
