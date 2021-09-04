package com.naruhin.springbootexamplehillelhw5.web;

import com.naruhin.springbootexamplehillelhw5.domain.Address;
import com.naruhin.springbootexamplehillelhw5.domain.Dealer;
import com.naruhin.springbootexamplehillelhw5.domain.Manufacturer;
import com.naruhin.springbootexamplehillelhw5.domain.ServiceStation;
import com.naruhin.springbootexamplehillelhw5.repository.AddressRepository;
import com.naruhin.springbootexamplehillelhw5.repository.ManufacturerRepository;
import com.naruhin.springbootexamplehillelhw5.repository.ServiceStationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ServiceStationRestController {
    private final ServiceStationRepository serviceStationRepository;
    private final AddressRepository addressRepository;

    public ServiceStationRestController(ServiceStationRepository serviceStationRepository, AddressRepository addressRepository) {
        this.serviceStationRepository = serviceStationRepository;
        this.addressRepository = addressRepository;
    }

    //Операция сохранения сервисного в базу данных
    @PostMapping("/service_stations/{addressId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ServiceStation saveServiceStation(@RequestBody ServiceStation serviceStation, @PathVariable long addressId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new EntityNotFoundException("Address not found with id = " + addressId));
        serviceStation.setAddress(address);
        return serviceStationRepository.save(serviceStation);
    }

    //Получение списка сервисных центров
    @GetMapping("/service_stations")
    @ResponseStatus(HttpStatus.OK)
    public Collection<ServiceStation> getAllServiceStations() {
        return serviceStationRepository.findAll();
    }

    //Удаление всех сервисных центров
    @DeleteMapping("/service_stations")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllServiceStations() {
        serviceStationRepository.deleteAll();
    }

    //Обновление сервисного центра
    @PutMapping("/service_stations/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ServiceStation updateServiceStation(@PathVariable("id") long id, @RequestBody ServiceStation serviceStation) {
        return serviceStationRepository.findById(id)
                .map(entity -> {
                    entity.setName(serviceStation.getName());
                    return serviceStationRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Service Station with id = Not found"));
    }
}
