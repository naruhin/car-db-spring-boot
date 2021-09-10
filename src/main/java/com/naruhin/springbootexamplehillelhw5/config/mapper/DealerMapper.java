package com.naruhin.springbootexamplehillelhw5.config.mapper;

import com.naruhin.springbootexamplehillelhw5.domain.Dealer;
import com.naruhin.springbootexamplehillelhw5.dto.DealerDTO;
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
