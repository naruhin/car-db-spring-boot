package com.naruhin.springbootexamplehillelhw5.service.impl;

import com.naruhin.springbootexamplehillelhw5.domain.Address;
import com.naruhin.springbootexamplehillelhw5.domain.Dealer;
import com.naruhin.springbootexamplehillelhw5.repository.AddressRepository;
import com.naruhin.springbootexamplehillelhw5.repository.DealerRepository;
import com.naruhin.springbootexamplehillelhw5.service.DealerService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@Service
public class DealerServiceImpl implements DealerService {
    private final AddressRepository addressRepository;
    private final DealerRepository dealerRepository;

    public DealerServiceImpl(AddressRepository addressRepository, DealerRepository dealerRepository) {
        this.addressRepository = addressRepository;
        this.dealerRepository = dealerRepository;
    }

    @Override
    public Dealer saveDealer(Dealer dealer, long addressId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new EntityNotFoundException("Address not found with id = " + addressId));
        dealer.setAddress(address);
        return dealerRepository.save(dealer);
    }


    @Override
    public Collection<Dealer> getAllDealers() {
        return dealerRepository.findAll();
    }

    @Override
    public Dealer getDealerById(long id) {
        return dealerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dealer not found with id = " + id));
    }

    @Override
    public void removeAllDealers() {
        dealerRepository.deleteAll();
    }

    @Override
    public Dealer updateDealer(long id, Dealer dealer) {
        return dealerRepository.findById(id)
                .map(entity -> {
                    entity.setName(dealer.getName());
                    return dealerRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Dealer with id = Not found"));
    }
}
