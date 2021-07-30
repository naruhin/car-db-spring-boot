package com.naruhin.springbootexamplehillelhw5.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Long> {
    List <Car> findAllByManufacturer(String manufacturer);
}
