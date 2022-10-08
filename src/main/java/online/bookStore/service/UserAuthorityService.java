package online.bookStore.service;

import online.bookStore.dto.ResponseDto;
import online.bookStore.dto.UserAuthorityDto;

import java.util.List;

public interface UserAuthorityService {
    ResponseDto<List<UserAuthorityDto>> getAllUserAuthorities();
    ResponseDto<UserAuthorityDto> getById(Integer id);
    ResponseDto add(UserAuthorityDto dto);
    ResponseDto update(UserAuthorityDto dto);
    ResponseDto delete(Integer id);
}
