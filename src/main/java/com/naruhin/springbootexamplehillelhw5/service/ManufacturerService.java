package com.naruhin.springbootexamplehillelhw5.service;

import com.naruhin.springbootexamplehillelhw5.domain.Manufacturer;

import java.util.Collection;

public interface ManufacturerService {
    Manufacturer saveManufacturer(Manufacturer manufacturer, long addressId);

    Collection<Manufacturer> getAllManufacturers();

    Manufacturer getManufacturerByID(long id);

    void removeAllManufacturers();

    Manufacturer updateManufacturer(long id, Manufacturer manufacturer);
}
