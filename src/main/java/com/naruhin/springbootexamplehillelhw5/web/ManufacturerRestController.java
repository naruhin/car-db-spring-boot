package com.naruhin.springbootexamplehillelhw5.web;

import com.naruhin.springbootexamplehillelhw5.config.AddressMapper;
import com.naruhin.springbootexamplehillelhw5.config.ManufacturerMapper;
import com.naruhin.springbootexamplehillelhw5.domain.Address;
import com.naruhin.springbootexamplehillelhw5.domain.Manufacturer;
import com.naruhin.springbootexamplehillelhw5.dto.ManufacturerDTO;
import com.naruhin.springbootexamplehillelhw5.service.AddressService;
import com.naruhin.springbootexamplehillelhw5.service.ManufacturerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ManufacturerRestController {
    private final AddressService addressService;
    private final ManufacturerService manufacturerService;

    public ManufacturerRestController(AddressService addressService, ManufacturerService manufacturerService) {
        this.addressService = addressService;
        this.manufacturerService = manufacturerService;
    }

    //Операция сохранения производителя в базу данных
    @PostMapping("/manufacturers/{addressId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ManufacturerDTO saveManufacturer(@RequestBody ManufacturerDTO manufacturerDTO, @PathVariable long addressId) {
        Address address = addressService.getAddressByID(addressId);
        Manufacturer manufacturer = ManufacturerMapper.INSTANCE.toManufacturer(manufacturerDTO);

        manufacturerDTO.setAddress(AddressMapper.INSTANCE.toAddressDto(address));

        return ManufacturerMapper.INSTANCE.toManufacturerDto(manufacturerService.saveManufacturer(manufacturer,addressId));
    }

    //Получение списка производителей
    @GetMapping("/manufacturers")
    @ResponseStatus(HttpStatus.OK)
    public Collection<ManufacturerDTO> getAllManufacturers() {
        Collection<Manufacturer> manufacturers = manufacturerService.getAllManufacturers();
        return ManufacturerMapper.INSTANCE.map((List<Manufacturer>) manufacturers);
    }

    //Удаление всех производителей
    @DeleteMapping("/manufacturers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllManufacturers() {
        manufacturerService.removeAllManufacturers();
    }

    //Обновление производителя
    @PutMapping("/manufacturers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ManufacturerDTO updateManufacturer(@PathVariable("id") long id, @RequestBody ManufacturerDTO manufacturerDTO) {
        Manufacturer manufacturer = ManufacturerMapper.INSTANCE.toManufacturer(manufacturerDTO);
        return  ManufacturerMapper.INSTANCE.toManufacturerDto(manufacturerService.updateManufacturer(id, manufacturer));
    }
}
