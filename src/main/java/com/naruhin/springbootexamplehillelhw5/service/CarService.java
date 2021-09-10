package com.naruhin.springbootexamplehillelhw5.service;

import com.naruhin.springbootexamplehillelhw5.domain.Car;

import java.util.Collection;

public interface CarService {

    public Car saveCar(Car car, long manufacturerId);

    public Collection<Car> getAllCars();

    public Car getCarById(long id);

    public Car updateCar(long id, Car car);

    public Car updateCarDealer(long carId, long dealerId);

    public Car updateCarServiceStation(long carId, long serviceStationId);

    public void removeAllCars();

    public void removeCarsById(long id);
}
