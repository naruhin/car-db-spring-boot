package com.naruhin.springbootexamplehillelhw5.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CARS")
@Getter
@Setter
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(cascade=CascadeType.DETACH)
    @JoinColumn(name="manufacturer_id" , nullable = false)
    private Manufacturer manufacturer;

    private String model;

    private String color;

    @ManyToOne(cascade=CascadeType.DETACH)
    @JoinColumn(name="dealer_id")
    private Dealer dealer;

    @ManyToOne(cascade=CascadeType.DETACH)
    @JoinColumn(name="service_station_id")
    @JsonIgnore
    private ServiceStation serviceStation;

    private String bodyStyle;

    @OneToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "engine_id", nullable = false)
    private Engine engine;

    public Car(String model, String color, String bodyStyle) {
        this.model = model;
        this.color = color;
        this.bodyStyle = bodyStyle;
    }
}
