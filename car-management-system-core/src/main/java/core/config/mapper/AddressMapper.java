package core.config.mapper;

import core.domain.Address;
import com.naruhin.api.dto.AddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper( AddressMapper.class );

    AddressDTO toAddressDto(Address address);

    Address toAddress(AddressDTO addressDTO);

    List<AddressDTO> map(List<Address> addresses);
}
