package com.naruhin.springbootexamplehillelhw5.web;

import com.naruhin.springbootexamplehillelhw5.domain.Address;
import com.naruhin.springbootexamplehillelhw5.repository.AddressRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class AddressRestController {

    private final AddressRepository addressRepository;

    public AddressRestController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    //Операция сохранения машины в базу данных
    @PostMapping("/addresses")
    @ResponseStatus(HttpStatus.CREATED)
    public Address saveAddress(@RequestBody Address address) {
        return addressRepository.save(address);
    }

    //Получение списка машин
    @GetMapping("/addresses")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    //Удаление всех машин
    @DeleteMapping("/addresses")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllAddresses() {
        addressRepository.deleteAll();
    }

    //Обновление машины
    @PutMapping("/addresses/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Address updateAddress(@PathVariable("id") long id, @RequestBody Address address) {
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
