package com.naruhin.springbootexamplehillelhw5.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SERVICE_STATIONS")
@Getter
@Setter
@NoArgsConstructor
public class ServiceStation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;


    @ManyToOne(cascade=CascadeType.MERGE, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy="serviceStation")
    private List<Car> cars = new ArrayList<>();

    public ServiceStation(String name) {
        this.name = name;
    }
}
