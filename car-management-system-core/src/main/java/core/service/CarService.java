package core.service;

import core.domain.Car;

import java.util.Collection;

public interface CarService {

    Car saveCar(Car car, long manufacturerId);

    Collection<Car> getAllCars();

    Car getCarById(long id);

    Car updateCar(long id, Car car);

    Car updateCarDealer(long carId, long dealerId);

    Car updateCarServiceStation(long carId, long serviceStationId);

    void removeAllCars();

    void removeCarsById(long id);
}
