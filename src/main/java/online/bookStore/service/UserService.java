package online.bookStore.service;

import online.bookStore.dto.JwtResponseDto;
import online.bookStore.dto.LoginDto;
import online.bookStore.dto.ResponseDto;
import online.bookStore.dto.UserDto;

import java.util.List;

public interface UserService {
    ResponseDto<List<UserDto>> getAllUser();
    ResponseDto<UserDto> getWithId(Integer id);
    ResponseDto addUser(UserDto userDto);
    ResponseDto updateUser(UserDto userDto);
    ResponseDto deleteUser(Integer id);

    ResponseDto<JwtResponseDto> login(LoginDto loginDto);
}
