package online.bookStore.service.impl;

import lombok.RequiredArgsConstructor;
import online.bookStore.dto.CityDto;
import online.bookStore.dto.ResponseDto;
import online.bookStore.entity.City;
import online.bookStore.repository.CityRepository;
import online.bookStore.service.CityService;
import online.bookStore.service.mapper.CityMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository repository;
    private final CityMapper cityMapper;

    @Override
    public ResponseDto<List<CityDto>> getAllCities() {
        List<City> list = repository.findAll();
        List<CityDto> cityDtos = list.stream()
                .map(cityMapper::toDto)
                .toList();

        return ResponseDto.<List<CityDto>>builder()
                .code(200)
                .success(true)
                .message("OK")
                .data(cityDtos)
                .build();
    }

    @Override
    public ResponseDto<CityDto> getById(Integer id) {
        if (repository.existsById(id)){
            City city = repository.findById(id).get();
            CityDto cityDto = cityMapper.toDto(city);

            return ResponseDto.<CityDto>builder()
                    .code(200)
                    .success(true)
                    .message("OK")
                    .data(cityDto)
                    .build();
        }
        return ResponseDto.<CityDto>builder()
                .code(-3)
                .success(false)
                .message("Doesn't exists")
                .build();
    }

    @Override
    public ResponseDto add(CityDto dto) {
        City city = cityMapper.toEntity(dto);
        repository.save(city);

        return ResponseDto.builder()
                .code(200)
                .success(true)
                .message("Successfully saved")
                .build();

    }

    @Override
    public ResponseDto update(CityDto dto) {
        if (repository.existsById(dto.getId())){
            City city =  cityMapper.toEntity(dto);
            repository.save(city);

            return ResponseDto.builder()
                    .code(200)
                    .success(true)
                    .message("Successfully updated")
                    .build();
        }
        return ResponseDto.builder()
                .code(-3)
                .success(false)
                .message("Doesn't exists")
                .build();
    }

    @Override
    public ResponseDto delete(Integer id) {
        if (repository.existsById(id)){
            repository.deleteById(id);

            return ResponseDto.builder()
                    .code(200)
                    .success(true)
                    .message("Successfully deleted")
                    .build();
        }

        return ResponseDto.builder()
                .code(-3)
                .success(false)
                .message("Doesn't exists")
                .build();
    }
}
