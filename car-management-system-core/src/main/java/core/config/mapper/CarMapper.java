package core.config.mapper;

import core.domain.Car;
import com.naruhin.api.dto.CarDTO;
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
