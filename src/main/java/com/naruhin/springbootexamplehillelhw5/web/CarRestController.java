package com.naruhin.springbootexamplehillelhw5.web;

import com.naruhin.springbootexamplehillelhw5.config.CarMapper;
import com.naruhin.springbootexamplehillelhw5.config.ManufacturerMapper;
import com.naruhin.springbootexamplehillelhw5.domain.Car;
import com.naruhin.springbootexamplehillelhw5.domain.Manufacturer;
import com.naruhin.springbootexamplehillelhw5.dto.CarDTO;
import com.naruhin.springbootexamplehillelhw5.service.CarService;
import com.naruhin.springbootexamplehillelhw5.service.ManufacturerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarRestController {

    private final CarService carService;
    private final ManufacturerService manufacturerService;

    public CarRestController(CarService carService, ManufacturerService manufacturerService) {
        this.carService = carService;
        this.manufacturerService = manufacturerService;
    }

    //Операция сохранения машины в базу данных
    @PostMapping("/cars/manufacturers/{manufacturerId}")
    @ResponseStatus(HttpStatus.CREATED)
    public CarDTO saveCar(@RequestBody CarDTO carDTO, @PathVariable long manufacturerId) {
        Manufacturer manufacturer = manufacturerService.getManufacturerByID(manufacturerId);
        Car car = CarMapper.INSTANCE.toCar(carDTO);
        carDTO.setManufacturer(ManufacturerMapper.INSTANCE.toManufacturerDto(manufacturer));
        carService.saveCar(car,manufacturerId);
        return CarMapper.INSTANCE.toCarDto(car);
    }

    //Получение списка машин
    @GetMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    public Collection<CarDTO> getAllCars() {
        List<Car> cars = (List<Car>) carService.getAllCars();
        return CarMapper.INSTANCE.map(cars);
    }

    //Получения машины по id
    @GetMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CarDTO getCarById(@PathVariable long id) {
        Car car = carService.getCarById(id);
        return CarMapper.INSTANCE.toCarDto(car);
    }

    //Обновление машины
    @PutMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CarDTO updateCar(@PathVariable("id") long id, @RequestBody CarDTO carDTO) {
        Car car = CarMapper.INSTANCE.toCar(carDTO);
        return  CarMapper.INSTANCE.toCarDto(carService.updateCar(id, car));
    }


    @PatchMapping("/cars/{carId}/dealers/{dealerId}")
    @ResponseStatus(HttpStatus.OK)
    public CarDTO updateCarDealer(@PathVariable long carId, @PathVariable long dealerId){
        carService.updateCarDealer(carId,dealerId);
        return CarMapper.INSTANCE.toCarDto(carService.getCarById(carId));
    }

    @PatchMapping("/cars/{carId}/service_stations/{serviceStationId}")
    @ResponseStatus(HttpStatus.OK)
    public CarDTO updateCarServiceStation(@PathVariable long carId, @PathVariable long serviceStationId){
        carService.updateCarServiceStation(carId,serviceStationId);
        return CarMapper.INSTANCE.toCarDto(carService.getCarById(carId));
    }


    //Удаление всех машин
    @DeleteMapping("/cars")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllCars() {
        carService.removeAllCars();
    }

    //Удаление по id
    @DeleteMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCarsById(@PathVariable long id) {
        carService.removeCarsById(id);
    }

}
