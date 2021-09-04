package com.naruhin.springbootexamplehillelhw5.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ADDRESSES")
@Setter
@Getter
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String country;

    private String city;

    private String street;

    private Long zipCode;

    @OneToMany(mappedBy = "address", fetch = FetchType.EAGER,
            cascade = CascadeType.DETACH)
    private Set<ServiceStation> serviceStations;

    @OneToMany(mappedBy = "address", fetch = FetchType.EAGER,
            cascade = CascadeType.DETACH)
    private Set<Dealer> dealers;

    @OneToMany(mappedBy = "address", fetch = FetchType.EAGER,
            cascade = CascadeType.DETACH)
    private Set<Manufacturer> manufacturers;


    public Address(String country, String city, String street, Long zipCode) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

}
