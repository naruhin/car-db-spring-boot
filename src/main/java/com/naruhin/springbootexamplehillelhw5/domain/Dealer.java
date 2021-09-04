package com.naruhin.springbootexamplehillelhw5.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "DEALERS")
@Getter
@Setter
@NoArgsConstructor
public class Dealer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @ManyToOne(cascade=CascadeType.MERGE, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "address_id")
    private Address address;


    public Dealer(String name) {
        this.name = name;
    }


}
