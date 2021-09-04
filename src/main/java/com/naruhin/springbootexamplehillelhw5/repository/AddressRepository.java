package com.naruhin.springbootexamplehillelhw5.repository;

import com.naruhin.springbootexamplehillelhw5.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
