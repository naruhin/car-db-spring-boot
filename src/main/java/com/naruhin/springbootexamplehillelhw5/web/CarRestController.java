package com.naruhin.springbootexamplehillelhw5.web;

import com.naruhin.springbootexamplehillelhw5.domain.Car;
import com.naruhin.springbootexamplehillelhw5.domain.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

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
        return repository.findAll();
    }

    //Получения машины по id
    @GetMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Car getCarById(@PathVariable long id) {

        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id = Not found"));
    }

    //Обновление машины
    @PutMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Car refreshEmployee(@PathVariable("id") long id, @RequestBody Car car) {

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

    //Удаление по id
    @DeleteMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCarsById(@PathVariable long id) {
        repository.deleteById(id);
    }

    //Удаление всех машин
    @DeleteMapping("/cars")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllCars() {
        repository.deleteAll();
    }

}
