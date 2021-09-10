package com.naruhin.springbootexamplehillelhw5.web;


import com.naruhin.springbootexamplehillelhw5.config.AddressMapper;
import com.naruhin.springbootexamplehillelhw5.config.DealerMapper;
import com.naruhin.springbootexamplehillelhw5.domain.Address;
import com.naruhin.springbootexamplehillelhw5.domain.Dealer;
import com.naruhin.springbootexamplehillelhw5.dto.DealerDTO;
import com.naruhin.springbootexamplehillelhw5.service.AddressService;
import com.naruhin.springbootexamplehillelhw5.service.DealerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class DealerRestController {
    private final AddressService addressService;
    private final DealerService dealerService;

    public DealerRestController(AddressService addressService, DealerService dealerService) {
        this.addressService = addressService;
        this.dealerService = dealerService;
    }

    //Операция сохранения дилера в базу данных
    @PostMapping("/dealers/{addressId}")
    @ResponseStatus(HttpStatus.CREATED)
    public DealerDTO saveAddress(@RequestBody DealerDTO dealerDTO, @PathVariable long addressId) {
        Address address = addressService.getAddressByID(addressId);
        Dealer dealer = DealerMapper.INSTANCE.toDealer(dealerDTO);
        dealerDTO.setAddress(AddressMapper.INSTANCE.toAddressDto(address));
        return DealerMapper.INSTANCE.toDealerDto(dealerService.saveDealer(dealer,addressId));
    }

    //Получение списка дилеров
    @GetMapping("/dealers")
    @ResponseStatus(HttpStatus.OK)
    public Collection<DealerDTO> getAllDealers() {
        Collection<Dealer> dealers = dealerService.getAllDealers();
        return DealerMapper.INSTANCE.map((List<Dealer>) dealers);
    }

    //Удаление всех дилеров
    @DeleteMapping("/dealers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllDealers() {
        dealerService.removeAllDealers();
    }

    //Обновление дилера
    @PutMapping("/dealers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DealerDTO updateDealer(@PathVariable("id") long id, @RequestBody DealerDTO dealerDTO) {
        Dealer dealer = DealerMapper.INSTANCE.toDealer(dealerDTO);
        return  DealerMapper.INSTANCE.toDealerDto(dealerService.updateDealer(id, dealer));
    }
}
