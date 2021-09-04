package com.naruhin.springbootexamplehillelhw5.web;

import com.naruhin.springbootexamplehillelhw5.domain.Dealer;
import com.naruhin.springbootexamplehillelhw5.domain.Manufacturer;
import com.naruhin.springbootexamplehillelhw5.domain.ServiceStation;
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

    public ServiceStationRestController(ServiceStationRepository serviceStationRepository) {
        this.serviceStationRepository = serviceStationRepository;
    }


    //Операция сохранения сервисного в базу данных
    @PostMapping("/service_stations")
    @ResponseStatus(HttpStatus.CREATED)
    public ServiceStation saveServiceStation(@RequestBody ServiceStation serviceStation) {
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
