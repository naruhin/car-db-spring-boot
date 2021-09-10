package com.naruhin.springbootexamplehillelhw5.service.impl;

import com.naruhin.springbootexamplehillelhw5.domain.Address;
import com.naruhin.springbootexamplehillelhw5.repository.AddressRepository;
import com.naruhin.springbootexamplehillelhw5.service.AddressService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Collection<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressByID(long id) {
        return addressRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Address not found with id = " + id));
    }

    @Override
    public void removeAllAddresses() {
        addressRepository.deleteAll();
    }

    @Override
    public Address updateAddress(long id, Address address) {
        return addressRepository.findById(id)
                .map(entity -> {
                    entity.setCountry(address.getCountry());
                    entity.setCity(address.getCity());
                    entity.setStreet(address.getStreet());
                    entity.setZipCode(address.getZipCode());
                    return addressRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Address with id = Not found"));
    }
}
