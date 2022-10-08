package online.bookStore.service.mapper;
import online.bookStore.dto.UserAuthorityDto;
import online.bookStore.entity.UserAuthority;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface UserAuthorityMapper {
    UserAuthority toEntity(UserAuthorityDto authorityDto);
    UserAuthorityDto toDto(UserAuthority user_authority);


}
