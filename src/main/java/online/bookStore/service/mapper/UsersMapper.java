package online.bookStore.service.mapper;

import online.bookStore.dto.UserDto;
import online.bookStore.entity.Authority;
import online.bookStore.entity.User;
import org.mapstruct.Mapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    User toEntity(UserDto userDto);
    UserDto toDto(User user);

    default SimpleGrantedAuthority parseToSimpleGranted(Authority authority){
        return new SimpleGrantedAuthority(authority.getPermission());
    }
}
