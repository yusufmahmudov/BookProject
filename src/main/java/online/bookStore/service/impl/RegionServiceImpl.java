package online.bookStore.service.impl;

import lombok.RequiredArgsConstructor;
import online.bookStore.dto.RegionDto;
import online.bookStore.dto.ResponseDto;
import online.bookStore.entity.Region;
import online.bookStore.repository.RegionRepository;
import online.bookStore.service.RegionService;
import online.bookStore.service.mapper.RegionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

    private final RegionRepository repository;
    private final RegionMapper regionMapper;

    @Override
    public ResponseDto<List<RegionDto>> getAllRegions() {
        List<Region> list = repository.findAll();
        List<RegionDto> regionDtos = list.stream()
                .map(regionMapper::toDto)
                .toList();

        return ResponseDto.<List<RegionDto>>builder()
                .code(200)
                .success(true)
                .message("OK")
                .data(regionDtos)
                .build();
    }

    @Override
    public ResponseDto<RegionDto> getById(Integer id) {
        if (repository.existsById(id)){
            Region region = repository.findById(id).get();
            RegionDto regionDto = regionMapper.toDto(region);

            return ResponseDto.<RegionDto>builder()
                    .code(200)
                    .success(true)
                    .message("OK")
                    .data(regionDto)
                    .build();
        }
        return ResponseDto.<RegionDto>builder()
                .code(-3)
                .success(false)
                .message("Doesn't exists")
                .build();
    }

    @Override
    public ResponseDto add(RegionDto dto) {
        Region region = regionMapper.toEntity(dto);
        repository.save(region);

        return ResponseDto.builder()
                .code(200)
                .success(true)
                .message("Successfully saved")
                .build();
    }

    @Override
    public ResponseDto update(RegionDto dto) {
        if (repository.existsById(dto.getId())){
            Region region = regionMapper.toEntity(dto);
            repository.save(region);

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
