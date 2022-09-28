package online.bookStore.service.mapper;

import online.bookStore.dto.UserDto;
import online.bookStore.entity.User;

public class UserMapper {
    public static User toEntity(UserDto userDto){
        return User.builder()
                .id(userDto.getId())
                .email(userDto.getEmail())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .password(userDto.getPassword())
                .phoneNumber(userDto.getPhoneNumber())
                .birthDate(userDto.getBirthDate())
                .username(userDto.getUsername())
                .build();
    }

    public static UserDto toDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .birthDate(user.getBirthDate())
                .username(user.getUsername())
                .build();
    }
}
