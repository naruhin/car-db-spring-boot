package com.naruhin.springbootexamplehillelhw5.service.impl;

import com.naruhin.springbootexamplehillelhw5.domain.Car;
import com.naruhin.springbootexamplehillelhw5.domain.Dealer;
import com.naruhin.springbootexamplehillelhw5.domain.Manufacturer;
import com.naruhin.springbootexamplehillelhw5.domain.ServiceStation;
import com.naruhin.springbootexamplehillelhw5.repository.CarRepository;
import com.naruhin.springbootexamplehillelhw5.repository.DealerRepository;
import com.naruhin.springbootexamplehillelhw5.repository.ManufacturerRepository;
import com.naruhin.springbootexamplehillelhw5.repository.ServiceStationRepository;
import com.naruhin.springbootexamplehillelhw5.service.CarService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final DealerRepository dealerRepository;
    private final ServiceStationRepository serviceStationRepository;

    public CarServiceImpl(CarRepository repository, ManufacturerRepository manufacturerRepository, DealerRepository dealerRepository, ServiceStationRepository serviceStationRepository) {
        this.carRepository = repository;
        this.manufacturerRepository = manufacturerRepository;
        this.dealerRepository = dealerRepository;
        this.serviceStationRepository = serviceStationRepository;
    }

    @Override
    public Car saveCar(Car car, long manufacturerId) {
        Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId)
                .orElseThrow(() -> new EntityNotFoundException("Manufacturer not found with id = " + manufacturerId));
        car.setManufacturer(manufacturer);
        return carRepository.save(car);
    }

    @Override
    public Collection<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(long id) {
        return carRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Car with id = Not found"));
    }

    @Override
    public Car updateCar(long id, Car car) {
        return carRepository.findById(id)
                .map(entity -> {
                    entity.setManufacturer(car.getManufacturer());
                    entity.setModel(car.getModel());
                    entity.setBodyStyle(car.getBodyStyle());
                    entity.setEngine(car.getEngine());
                    entity.setColor(car.getColor());
                    return carRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Car with id = Not found"));
    }

    @Override
    public Car updateCarDealer(long carId, long dealerId) {
        Dealer dealer = dealerRepository.findById(dealerId)
                .orElseThrow(() -> new EntityNotFoundException("Dealer not found with id = " + dealerId));
        return carRepository.findById(carId)
                .map(entity -> {
                    entity.setDealer(dealer);
                    return  carRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Car with id = Not found"));
    }

    @Override
    public Car updateCarServiceStation(long carId, long serviceStationId) {
        ServiceStation serviceStation = serviceStationRepository.findById(serviceStationId)
                .orElseThrow(() -> new EntityNotFoundException("Service Station not found with id = " + serviceStationId));
        return carRepository.findById(carId)
                .map(entity -> {
                    entity.setServiceStation(serviceStation);
                    return  carRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Car with id = Not found"));
    }

    @Override
    public void removeAllCars() {
        carRepository.deleteAll();
    }

    @Override
    public void removeCarsById(long id) {
        carRepository.deleteById(id);
    }
}
