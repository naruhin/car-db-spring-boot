package com.naruhin.springbootexamplehillelhw5.web;

import com.naruhin.springbootexamplehillelhw5.domain.Car;
import com.naruhin.springbootexamplehillelhw5.domain.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarRestController {

    private final CarRepository repository;

    public CarRestController(CarRepository repository) {
        this.repository = repository;
    }

    //Операция сохранения машины в базу данных
    @PostMapping("/cars")
    @ResponseStatus(HttpStatus.CREATED)
    public Car saveCar(@RequestBody Car car) {
        return repository.save(car);
    }

    //Получение списка машин
    @GetMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Car> getAllCars() {
        return repository.findAllByDeletedIsFalse();
    }


    //Получение списка машин по производителю
    @GetMapping("/cars/manufacturer/{manufacturer}")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Car> getAllCarsByManufacturer(@PathVariable("manufacturer") String manufacturer) {
        return repository.findAllByManufacturerAndDeletedIsFalse(manufacturer);
    }

    //Получения машины по id
    @GetMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Car getCarById(@PathVariable long id) {
        return repository.findByIdAndDeletedIsFalse(id);
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
                .orElseThrow(() -> new EntityNotFoundException("Employee with id = Not found"));
    }


    //Удаление всех сущностей
    @PatchMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteAllCars() {
        List<Car> cars = repository.getAllByDeletedIsFalse();
        for (Car car : cars) {
            car.setDeleted(true);
            repository.save(car);
        }
    }

    //Удаление по id
    @PatchMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public Car deleteCar(@PathVariable("id") long id) {
        Car car = repository.getById(id);
        car.setDeleted(true);
        return repository.save(car);
    }


    //TODO Old delete methods
    /*
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
*/

}
