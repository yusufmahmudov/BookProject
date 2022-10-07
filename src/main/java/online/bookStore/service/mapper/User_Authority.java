package online.bookStore.service.mapper;
import online.bookStore.dto.User_AuthorityDto;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface User_Authority {
    User_Authority toEntity(User_AuthorityDto authorityDto);
    User_AuthorityDto toDto(User_Authority user_authority);
}
