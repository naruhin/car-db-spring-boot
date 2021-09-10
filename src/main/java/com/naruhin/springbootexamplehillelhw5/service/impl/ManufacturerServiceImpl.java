package com.naruhin.springbootexamplehillelhw5.service.impl;

import com.naruhin.springbootexamplehillelhw5.domain.Address;
import com.naruhin.springbootexamplehillelhw5.domain.Manufacturer;
import com.naruhin.springbootexamplehillelhw5.repository.AddressRepository;
import com.naruhin.springbootexamplehillelhw5.repository.ManufacturerRepository;
import com.naruhin.springbootexamplehillelhw5.service.ManufacturerService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;
    private final AddressRepository addressRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository, AddressRepository addressRepository) {
        this.manufacturerRepository = manufacturerRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public Manufacturer saveManufacturer(Manufacturer manufacturer, long addressId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new EntityNotFoundException("Address not found with id = " + addressId));
        manufacturer.setAddress(address);
        return manufacturerRepository.save(manufacturer);
    }

    @Override
    public Collection<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Manufacturer getManufacturerByID(long id) {
        return manufacturerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Manufacturer not found with id = " + id));
    }

    @Override
    public void removeAllManufacturers() {
        manufacturerRepository.deleteAll();
    }

    @Override
    public Manufacturer updateManufacturer(long id, Manufacturer manufacturer) {
        return manufacturerRepository.findById(id)
                .map(entity -> {
                    entity.setName(manufacturer.getName());
                    return manufacturerRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Manufacturer with id = Not found"));
    }
}
