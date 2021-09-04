package com.naruhin.springbootexamplehillelhw5;

import com.naruhin.springbootexamplehillelhw5.domain.*;
import com.naruhin.springbootexamplehillelhw5.repository.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootExampleHillelHw5ApplicationTests {


    @Autowired
    AddressRepository addressRepository;

    @Autowired
    DealerRepository dealerRepository;

    @Autowired
    ManufacturerRepository manufacturerRepository;

    @Autowired
    ServiceStationRepository serviceStationRepository;

    @Autowired
    CarRepository carRepository;

    @Test
    void initData() {
        Address address = new Address("Ukraine","Odessa","Zabolotnoho",65025L);
        addressRepository.save(address);

        Dealer dealer = new Dealer("LuxuryAuto's");
        Manufacturer manufacturer = new Manufacturer("Toyota");
        ServiceStation serviceStation = new ServiceStation("СТО №1");
        serviceStation.setAddress(address);
        dealer.setAddress(address);
        manufacturer.setAddress(address);

        serviceStationRepository.save(serviceStation);
        addressRepository.save(address);
        dealerRepository.save(dealer);
        manufacturerRepository.save(manufacturer);

        Engine engine = new Engine("test","test","test","test","test");

        // create a new book
        Car car = new Car( "model x","white","coupe");
        car.setDealer(dealer);
        car.setEngine(engine);
        car.setManufacturer(manufacturer);
        car.setServiceStation(serviceStation);

        // save the book
        carRepository.save(car);


    }

}
