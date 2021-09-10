package com.naruhin.springbootexamplehillelhw5.config.mapper;

import com.naruhin.springbootexamplehillelhw5.domain.Car;
import com.naruhin.springbootexamplehillelhw5.dto.CarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper( CarMapper.class );

    CarDTO toCarDto(Car car);

    Car toCar(CarDTO CarDTO);

    List<CarDTO> map(List<Car> cars);
}
