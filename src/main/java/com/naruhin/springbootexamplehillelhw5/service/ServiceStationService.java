package com.naruhin.springbootexamplehillelhw5.service;

import com.naruhin.springbootexamplehillelhw5.domain.ServiceStation;

import java.util.Collection;

public interface ServiceStationService {
    ServiceStation saveServiceStation(ServiceStation serviceStation,long addressId);

    Collection<ServiceStation> getAllServiceStations();

    ServiceStation getServiceStationById(long serviceStationId);

    void removeAllServiceStations();

    ServiceStation updateServiceStation(long id, ServiceStation serviceStation);
}
