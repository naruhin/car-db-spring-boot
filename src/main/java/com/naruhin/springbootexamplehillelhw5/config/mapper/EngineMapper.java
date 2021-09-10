package com.naruhin.springbootexamplehillelhw5.config.mapper;

import com.naruhin.springbootexamplehillelhw5.domain.Engine;
import com.naruhin.springbootexamplehillelhw5.dto.EngineDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EngineMapper {
    EngineMapper INSTANCE = Mappers.getMapper( EngineMapper.class );

    EngineDTO toEngineDto(Engine engine);

    Engine toEngine(EngineDTO engineDTO);
}
