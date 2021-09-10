package com.naruhin.springbootexamplehillelhw5.service;

import com.naruhin.springbootexamplehillelhw5.domain.Manufacturer;

import java.util.Collection;

public interface ManufacturerService {
    public Manufacturer saveManufacturer(Manufacturer manufacturer,long addressId);

    public Collection<Manufacturer> getAllManufacturers();

    public Manufacturer getManufacturerByID(long id);

    public void removeAllManufacturers();

    public Manufacturer updateManufacturer(long id, Manufacturer manufacturer);
}
