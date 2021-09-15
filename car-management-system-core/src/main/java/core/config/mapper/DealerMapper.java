package core.config.mapper;

import core.domain.Dealer;
import com.naruhin.api.dto.DealerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DealerMapper {
    DealerMapper INSTANCE = Mappers.getMapper( DealerMapper.class );

    DealerDTO toDealerDto(Dealer dealer);

    Dealer toDealer(DealerDTO dealerDTO);

    List<DealerDTO> map(List<Dealer> dealers);
}
