package com.naruhin.springbootexamplehillelhw5.web.impl;

import com.naruhin.springbootexamplehillelhw5.config.mapper.AddressMapper;
import com.naruhin.springbootexamplehillelhw5.config.mapper.ServiceStationMapper;
import com.naruhin.springbootexamplehillelhw5.domain.Address;
import com.naruhin.springbootexamplehillelhw5.domain.ServiceStation;
import com.naruhin.springbootexamplehillelhw5.dto.ServiceStationDTO;
import com.naruhin.springbootexamplehillelhw5.service.AddressService;
import com.naruhin.springbootexamplehillelhw5.service.ServiceStationService;
import com.naruhin.springbootexamplehillelhw5.web.ServiceStationRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ServiceStationRestControllerImpl implements ServiceStationRestController {
    private final AddressService addressService;
    private final ServiceStationService serviceStationService;

    public ServiceStationRestControllerImpl(AddressService addressService, ServiceStationService serviceStationService) {
        this.addressService = addressService;
        this.serviceStationService = serviceStationService;
    }

    //Операция сохранения сервисного в базу данных
    @PostMapping("/service_stations/{addressId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ServiceStationDTO saveServiceStation(@RequestBody ServiceStationDTO serviceStationDTO, @PathVariable long addressId) {
        Address address = addressService.getAddressByID(addressId);
        ServiceStation serviceStation = ServiceStationMapper.INSTANCE.toServiceStation(serviceStationDTO);

        serviceStationDTO.setAddress(AddressMapper.INSTANCE.toAddressDto(address));

        return ServiceStationMapper.INSTANCE.toServiceStationDto(serviceStationService.saveServiceStation(serviceStation,addressId));
    }

    //Получение списка сервисных центров
    @GetMapping("/service_stations")
    @ResponseStatus(HttpStatus.OK)
    public Collection<ServiceStationDTO> getAllServiceStations() {
        Collection<ServiceStation> serviceStations = serviceStationService.getAllServiceStations();
        return ServiceStationMapper.INSTANCE.map((List<ServiceStation>) serviceStations);
    }

    //Удаление всех сервисных центров
    @DeleteMapping("/service_stations")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllServiceStations() {
        serviceStationService.removeAllServiceStations();
    }

    //Обновление сервисного центра
    @PutMapping("/service_stations/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ServiceStationDTO updateServiceStation(@PathVariable("id") long id, @RequestBody ServiceStationDTO serviceStationDTO) {
        ServiceStation serviceStation = ServiceStationMapper.INSTANCE.toServiceStation(serviceStationDTO);
        return  ServiceStationMapper.INSTANCE.toServiceStationDto(serviceStationService.updateServiceStation(id, serviceStation));
    }
}
