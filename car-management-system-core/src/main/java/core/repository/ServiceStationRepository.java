package core.repository;

import core.domain.ServiceStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceStationRepository extends JpaRepository<ServiceStation,Long> {
}
