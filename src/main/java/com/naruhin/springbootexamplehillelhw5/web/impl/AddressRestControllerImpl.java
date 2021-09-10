package com.naruhin.springbootexamplehillelhw5.web.impl;

import com.naruhin.springbootexamplehillelhw5.config.mapper.AddressMapper;
import com.naruhin.springbootexamplehillelhw5.domain.Address;
import com.naruhin.springbootexamplehillelhw5.dto.AddressDTO;
import com.naruhin.springbootexamplehillelhw5.service.AddressService;
import com.naruhin.springbootexamplehillelhw5.web.AddressRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class AddressRestControllerImpl implements AddressRestController {

    private final AddressService service;

    public AddressRestControllerImpl(AddressService service) {
        this.service = service;
    }


    @PostMapping("/addresses")
    @ResponseStatus(HttpStatus.CREATED)
    public AddressDTO saveAddress(@RequestBody AddressDTO addressDTO) {
        Address address = AddressMapper.INSTANCE.toAddress(addressDTO);
        return AddressMapper.INSTANCE.toAddressDto(service.saveAddress(address));
    }


    @GetMapping("/addresses")
    @ResponseStatus(HttpStatus.OK)
    public List<AddressDTO> getAllAddresses() {
        Collection<Address> addresses = service.getAllAddresses();
        return AddressMapper.INSTANCE.map((List<Address>) addresses);
    }


    @DeleteMapping("/addresses")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllAddresses() {
        service.removeAllAddresses();
    }


    @PutMapping("/addresses/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AddressDTO updateAddress(@PathVariable("id") long id, @RequestBody AddressDTO addressDTO) {
        Address address = AddressMapper.INSTANCE.toAddress(addressDTO);
        return AddressMapper.INSTANCE.toAddressDto(service.updateAddress(id,address));

    }

}
