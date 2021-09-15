package core.service;

import core.domain.ServiceStation;

import java.util.Collection;

public interface ServiceStationService {
    ServiceStation saveServiceStation(ServiceStation serviceStation, long addressId);

    Collection<ServiceStation> getAllServiceStations();

    ServiceStation getServiceStationById(long serviceStationId);

    void removeAllServiceStations();

    ServiceStation updateServiceStation(long id, ServiceStation serviceStation);
}
