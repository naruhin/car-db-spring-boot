package com.naruhin.springbootexamplehillelhw5.web.impl;

import com.naruhin.springbootexamplehillelhw5.config.mapper.AddressMapper;
import com.naruhin.springbootexamplehillelhw5.config.mapper.ManufacturerMapper;
import com.naruhin.springbootexamplehillelhw5.domain.Address;
import com.naruhin.springbootexamplehillelhw5.domain.Manufacturer;
import com.naruhin.springbootexamplehillelhw5.dto.ManufacturerDTO;
import com.naruhin.springbootexamplehillelhw5.service.AddressService;
import com.naruhin.springbootexamplehillelhw5.service.ManufacturerService;
import com.naruhin.springbootexamplehillelhw5.web.ManufacturerRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ManufacturerRestControllerImpl implements ManufacturerRestController {
    private final AddressService addressService;
    private final ManufacturerService manufacturerService;

    public ManufacturerRestControllerImpl(AddressService addressService, ManufacturerService manufacturerService) {
        this.addressService = addressService;
        this.manufacturerService = manufacturerService;
    }


    @PostMapping("/manufacturers/{addressId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ManufacturerDTO saveManufacturer(@RequestBody ManufacturerDTO manufacturerDTO, @PathVariable long addressId) {
        Address address = addressService.getAddressByID(addressId);
        Manufacturer manufacturer = ManufacturerMapper.INSTANCE.toManufacturer(manufacturerDTO);

        manufacturerDTO.setAddress(AddressMapper.INSTANCE.toAddressDto(address));

        return ManufacturerMapper.INSTANCE.toManufacturerDto(manufacturerService.saveManufacturer(manufacturer,addressId));
    }


    @GetMapping("/manufacturers")
    @ResponseStatus(HttpStatus.OK)
    public Collection<ManufacturerDTO> getAllManufacturers() {
        Collection<Manufacturer> manufacturers = manufacturerService.getAllManufacturers();
        return ManufacturerMapper.INSTANCE.map((List<Manufacturer>) manufacturers);
    }


    @DeleteMapping("/manufacturers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllManufacturers() {
        manufacturerService.removeAllManufacturers();
    }


    @PutMapping("/manufacturers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ManufacturerDTO updateManufacturer(@PathVariable("id") long id, @RequestBody ManufacturerDTO manufacturerDTO) {
        Manufacturer manufacturer = ManufacturerMapper.INSTANCE.toManufacturer(manufacturerDTO);
        return  ManufacturerMapper.INSTANCE.toManufacturerDto(manufacturerService.updateManufacturer(id, manufacturer));
    }
}
