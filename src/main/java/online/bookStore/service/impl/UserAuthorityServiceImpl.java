package online.bookStore.service.impl;

import lombok.RequiredArgsConstructor;
import online.bookStore.dto.ResponseDto;
import online.bookStore.dto.UserAuthorityDto;
import online.bookStore.repository.UserAuthorityRepository;
import online.bookStore.service.UserAuthorityService;
import online.bookStore.service.mapper.UserAuthorityMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAuthorityServiceImpl implements UserAuthorityService {
    private final UserAuthorityRepository repository;
    private final UserAuthorityMapper mapper;

    @Override
    public ResponseDto<List<UserAuthorityDto>> getAllUserAuthorities() {

        return null;
    }

    @Override
    public ResponseDto<UserAuthorityDto> getById(Integer id) {
        return null;
    }

    @Override
    public ResponseDto add(UserAuthorityDto dto) {
        return null;
    }

    @Override
    public ResponseDto update(UserAuthorityDto dto) {
        return null;
    }

    @Override
    public ResponseDto delete(Integer id) {
        return null;
    }
}
