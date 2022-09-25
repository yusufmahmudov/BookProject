package online.library.service;

import online.library.dto.PublisherDto;
import online.library.dto.ResponseDto;
import online.library.dto.UserDto;

import java.util.List;

public interface UserService {
    ResponseDto<List<UserDto>> getAllUser();
    ResponseDto<UserDto> getWithId(Integer id);
    ResponseDto addUser(UserDto userDto);
    ResponseDto updateUser(UserDto userDto);
    ResponseDto deleteUser(Integer id);
}
