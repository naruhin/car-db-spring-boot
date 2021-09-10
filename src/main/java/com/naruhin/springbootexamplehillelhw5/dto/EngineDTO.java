package com.naruhin.springbootexamplehillelhw5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EngineDTO {
    private String type;

    private String engineVolume;

    private String engineLayoutType;

    private String torque;

    private String power;
}
