package com.naruhin.springbootexamplehillelhw5.repository;

import com.naruhin.springbootexamplehillelhw5.domain.ServiceStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceStationRepository extends JpaRepository<ServiceStation,Long> {
}
