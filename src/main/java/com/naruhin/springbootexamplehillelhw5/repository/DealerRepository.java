package com.naruhin.springbootexamplehillelhw5.repository;

import com.naruhin.springbootexamplehillelhw5.domain.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealerRepository extends JpaRepository<Dealer,Long> {
}
