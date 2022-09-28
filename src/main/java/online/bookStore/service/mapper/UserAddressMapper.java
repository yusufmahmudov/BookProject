package online.bookStore.service.mapper;

import online.bookStore.dto.UserAddressDto;
import online.bookStore.entity.UserAddress;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserAddressMapper {
    UserAddress toEntity(UserAddressDto dto);
    UserAddressDto toDto(UserAddress userAddress);
}
