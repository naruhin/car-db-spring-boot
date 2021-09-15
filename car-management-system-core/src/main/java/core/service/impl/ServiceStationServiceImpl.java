package core.service.impl;

import core.domain.Address;
import core.domain.ServiceStation;
import core.repository.AddressRepository;
import core.service.ServiceStationService;
import core.repository.ServiceStationRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@Service
public class ServiceStationServiceImpl implements ServiceStationService {
    private final ServiceStationRepository serviceStationRepository;
    private final AddressRepository addressRepository;

    public ServiceStationServiceImpl(ServiceStationRepository serviceStationRepository, AddressRepository addressRepository) {
        this.serviceStationRepository = serviceStationRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public ServiceStation saveServiceStation(ServiceStation serviceStation, long addressId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new EntityNotFoundException("Address not found with id = " + addressId));
        serviceStation.setAddress(address);
        return serviceStationRepository.save(serviceStation);
    }

    @Override
    public Collection<ServiceStation> getAllServiceStations() {
        return serviceStationRepository.findAll();
    }

    @Override
    public ServiceStation getServiceStationById(long serviceStationId) {
        return serviceStationRepository.findById(serviceStationId)
                .orElseThrow(() -> new EntityNotFoundException("Service Station not found with id = " + serviceStationId));
    }

    @Override
    public void removeAllServiceStations() {
        serviceStationRepository.deleteAll();
    }

    @Override
    public ServiceStation updateServiceStation(long id, ServiceStation serviceStation) {
        return serviceStationRepository.findById(id)
                .map(entity -> {
                    entity.setName(serviceStation.getName());
                    return serviceStationRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Service Station with id = Not found"));
    }
}
