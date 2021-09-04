package com.naruhin.springbootexamplehillelhw5.repository;

import com.naruhin.springbootexamplehillelhw5.domain.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer,Long> {
}
