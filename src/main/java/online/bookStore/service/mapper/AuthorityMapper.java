package online.bookStore.service.mapper;

import online.bookStore.dto.AuthorityDto;
import online.bookStore.entity.Authority;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorityMapper {
    Authority toEntity(AuthorityDto authorityDto);
    AuthorityDto toDto(Authority authority);
}
