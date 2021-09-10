package com.naruhin.springbootexamplehillelhw5.service;

import com.naruhin.springbootexamplehillelhw5.domain.Address;

import java.util.Collection;

public interface AddressService {
    public Address saveAddress(Address address);

    public Collection<Address> getAllAddresses();

    public Address getAddressByID(long id);

    public void removeAllAddresses();

    public Address updateAddress(long id, Address address);

}
