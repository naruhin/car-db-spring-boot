package core.config.mapper;

import core.domain.ServiceStation;
import com.naruhin.api.dto.ServiceStationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ServiceStationMapper {
    ServiceStationMapper INSTANCE = Mappers.getMapper( ServiceStationMapper.class );

    ServiceStationDTO toServiceStationDto(ServiceStation serviceStation);

    ServiceStation toServiceStation(ServiceStationDTO ServiceStationDTO);

    List<ServiceStationDTO> map(List<ServiceStation> serviceStation);
}
