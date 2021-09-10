package com.naruhin.springbootexamplehillelhw5.service;

import com.naruhin.springbootexamplehillelhw5.domain.Dealer;

import java.util.Collection;

public interface DealerService {

    public Dealer saveDealer(Dealer dealer, long addressId);

    public Collection<Dealer> getAllDealers();

    public Dealer getDealerById(long id);

    public void removeAllDealers();

    public Dealer updateDealer(long id, Dealer dealer);

}
