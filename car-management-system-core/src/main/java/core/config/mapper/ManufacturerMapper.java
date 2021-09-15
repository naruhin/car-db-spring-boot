package core.config.mapper;

import core.domain.Manufacturer;
import com.naruhin.api.dto.ManufacturerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ManufacturerMapper {
    ManufacturerMapper INSTANCE = Mappers.getMapper( ManufacturerMapper.class );

    ManufacturerDTO toManufacturerDto(Manufacturer manufacturer);

    Manufacturer toManufacturer(ManufacturerDTO manufacturerDTO);

    List<ManufacturerDTO> map(List<Manufacturer>  manufacturers);
}
