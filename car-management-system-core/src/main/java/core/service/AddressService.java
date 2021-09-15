package core.service;

import core.domain.Address;

import java.util.Collection;

public interface AddressService {
    Address saveAddress(Address address);

    Collection<Address> getAllAddresses();

    Address getAddressByID(long id);

    void removeAllAddresses();

    Address updateAddress(long id, Address address);

}
