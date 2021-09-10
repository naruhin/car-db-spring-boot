package com.naruhin.springbootexamplehillelhw5.service;

import com.naruhin.springbootexamplehillelhw5.domain.ServiceStation;

import java.util.Collection;

public interface ServiceStationService {
    public ServiceStation saveServiceStation(ServiceStation serviceStation,long addressId);

    public Collection<ServiceStation> getAllServiceStations();

    public ServiceStation getServiceStationById(long serviceStationId);

    public void removeAllServiceStations();

    public ServiceStation updateServiceStation(long id, ServiceStation serviceStation);
}
