package com.naruhin.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarUpdateDTO {

    private String color;

    private EngineDTO engine;
}
