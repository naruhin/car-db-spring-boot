package com.naruhin.springbootexamplehillelhw5.web;

import com.naruhin.springbootexamplehillelhw5.config.AddressMapper;
import com.naruhin.springbootexamplehillelhw5.domain.Address;
import com.naruhin.springbootexamplehillelhw5.dto.AddressDTO;
import com.naruhin.springbootexamplehillelhw5.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class AddressRestController {

    private final AddressService service;

    public AddressRestController(AddressService service) {
        this.service = service;
    }

    //Операция сохранения адресов в базу данных
    @PostMapping("/addresses")
    @ResponseStatus(HttpStatus.CREATED)
    public AddressDTO saveAddress(@RequestBody AddressDTO addressDTO) {
        Address address = AddressMapper.INSTANCE.toAddress(addressDTO);
        return AddressMapper.INSTANCE.toAddressDto(service.saveAddress(address));
    }

    //Получение списка адресов
    @GetMapping("/addresses")
    @ResponseStatus(HttpStatus.OK)
    public List<AddressDTO> getAllAddresses() {
        Collection<Address> addresses = service.getAllAddresses();
        return AddressMapper.INSTANCE.map((List<Address>) addresses);
    }

    //Удаление всех адресов
    @DeleteMapping("/addresses")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllAddresses() {
        service.removeAllAddresses();
    }

    //Обновление адреса
    @PutMapping("/addresses/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AddressDTO updateAddress(@PathVariable("id") long id, @RequestBody AddressDTO addressDTO) {
        Address address = AddressMapper.INSTANCE.toAddress(addressDTO);
        return AddressMapper.INSTANCE.toAddressDto(service.updateAddress(id,address));

    }

}
