package com.naruhin.springbootexamplehillelhw5.web;

import com.naruhin.springbootexamplehillelhw5.domain.Car;
import com.naruhin.springbootexamplehillelhw5.domain.Dealer;
import com.naruhin.springbootexamplehillelhw5.domain.Manufacturer;
import com.naruhin.springbootexamplehillelhw5.domain.ServiceStation;
import com.naruhin.springbootexamplehillelhw5.repository.CarRepository;
import com.naruhin.springbootexamplehillelhw5.repository.DealerRepository;
import com.naruhin.springbootexamplehillelhw5.repository.ManufacturerRepository;
import com.naruhin.springbootexamplehillelhw5.repository.ServiceStationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarRestController {

    private final CarRepository repository;
    private final ManufacturerRepository manufacturerRepository;
    private final DealerRepository dealerRepository;
    private final ServiceStationRepository serviceStationRepository;

    public CarRestController(CarRepository repository, ManufacturerRepository manufacturerRepository, DealerRepository dealerRepository, ServiceStationRepository serviceStationRepository) {
        this.repository = repository;
        this.manufacturerRepository = manufacturerRepository;
        this.dealerRepository = dealerRepository;
        this.serviceStationRepository = serviceStationRepository;
    }


    //Операция сохранения машины в базу данных
    @PostMapping("/cars/manufacturers/{manufacturerId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Car saveCar(@RequestBody Car car, @PathVariable long manufacturerId) {
        Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId)
                .orElseThrow(() -> new EntityNotFoundException("Manufacturer not found with id = " + manufacturerId));
        car.setManufacturer(manufacturer);
        return repository.save(car);
    }

    //Получение списка машин
    @GetMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Car> getAllCars() {
        return repository.findAll();
    }

    //Получения машины по id
    @GetMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Car> getCarById(@PathVariable long id) {
        return repository.findById(id);
    }

    //Обновление машины
    @PutMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Car updateCar(@PathVariable("id") long id, @RequestBody Car car) {
        return repository.findById(id)
                .map(entity -> {
                        entity.setManufacturer(car.getManufacturer());
                        entity.setModel(car.getModel());
                        entity.setBodyStyle(car.getBodyStyle());
                        entity.setEngine(car.getEngine());
                        entity.setColor(car.getColor());
                        return repository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Car with id = Not found"));
    }


    @PatchMapping("/cars/{carId}/dealers/{dealerId}")
    @ResponseStatus(HttpStatus.OK)
    public Car updateCarDealer(@PathVariable long carId, @PathVariable long dealerId){
        Dealer dealer = dealerRepository.findById(dealerId)
                .orElseThrow(() -> new EntityNotFoundException("Dealer not found with id = " + dealerId));
        return repository.findById(carId)
                .map(entity -> {
                    entity.setDealer(dealer);
                    return  repository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Car with id = Not found"));
    }

    @PatchMapping("/cars/{carId}/service_stations/{serviceStationId}")
    @ResponseStatus(HttpStatus.OK)
    public Car updateCarServiceStation(@PathVariable long carId, @PathVariable long serviceStationId){
        ServiceStation serviceStation = serviceStationRepository.findById(serviceStationId)
                .orElseThrow(() -> new EntityNotFoundException("Service Station not found with id = " + serviceStationId));
        return repository.findById(carId)
                .map(entity -> {
                    entity.setServiceStation(serviceStation);
                    return  repository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Car with id = Not found"));
    }


    //Удаление всех машин
    @DeleteMapping("/cars")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllCars() {
        repository.deleteAll();
    }

    //Удаление по id
    @DeleteMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCarsById(@PathVariable long id) {
        repository.deleteById(id);
    }

}
