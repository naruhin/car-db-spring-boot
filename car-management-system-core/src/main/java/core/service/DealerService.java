package core.service;

import core.domain.Dealer;

import java.util.Collection;

public interface DealerService {

    Dealer saveDealer(Dealer dealer, long addressId);

    Collection<Dealer> getAllDealers();

    Dealer getDealerById(long id);

    void removeAllDealers();

    Dealer updateDealer(long id, Dealer dealer);

}
