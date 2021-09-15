package core.config.mapper;

import core.domain.Engine;
import com.naruhin.api.dto.EngineDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EngineMapper {
    EngineMapper INSTANCE = Mappers.getMapper( EngineMapper.class );

    EngineDTO toEngineDto(Engine engine);

    Engine toEngine(EngineDTO engineDTO);
}
