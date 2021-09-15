package core.repository;

import core.domain.Car;
import core.domain.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Long> {
    List<Car> findAllByManufacturer(Manufacturer manufacturer);
}
