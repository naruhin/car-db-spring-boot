package core.controller.impl;

import com.naruhin.api.dto.CarUpdateDTO;
import core.config.mapper.CarMapper;
import core.domain.Car;
import core.domain.Manufacturer;
import core.service.CarService;
import core.service.ManufacturerService;
import core.config.mapper.ManufacturerMapper;
import com.naruhin.api.dto.CarDTO;
import com.naruhin.api.controller.CarRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarRestControllerImpl implements CarRestController {

    private final CarService carService;
    private final ManufacturerService manufacturerService;

    public CarRestControllerImpl(CarService carService, ManufacturerService manufacturerService) {
        this.carService = carService;
        this.manufacturerService = manufacturerService;
    }



    @PostMapping("/cars/manufacturers/{manufacturerId}")
    @ResponseStatus(HttpStatus.CREATED)
    public CarDTO saveCar(@RequestBody CarDTO carDTO, @PathVariable long manufacturerId) {
        Manufacturer manufacturer = manufacturerService.getManufacturerByID(manufacturerId);
        Car car = CarMapper.INSTANCE.toCar(carDTO);
        carDTO.setManufacturer(ManufacturerMapper.INSTANCE.toManufacturerDto(manufacturer));
        carService.saveCar(car,manufacturerId);
        return CarMapper.INSTANCE.toCarDto(car);
    }


    @GetMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    public Collection<CarDTO> getAllCars() {
        List<Car> cars = (List<Car>) carService.getAllCars();
        return CarMapper.INSTANCE.map(cars);
    }


    @GetMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CarDTO getCarById(@PathVariable long id) {
        Car car = carService.getCarById(id);
        return CarMapper.INSTANCE.toCarDto(car);
    }


    @PutMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CarDTO updateCar(@PathVariable("id") long id, @RequestBody CarUpdateDTO carDTO) {
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



    @DeleteMapping("/cars")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllCars() {
        carService.removeAllCars();
    }


    @DeleteMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCarsById(@PathVariable long id) {
        carService.removeCarsById(id);
    }

}
