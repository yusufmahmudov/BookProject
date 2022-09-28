package online.bookStore.service;

import online.bookStore.dto.RegionDto;
import online.bookStore.dto.ResponseDto;
import online.bookStore.dto.UserAddressDto;

import java.util.List;

public interface RegionService {
    ResponseDto<List<RegionDto>> getAllRegions();
    ResponseDto<RegionDto> getById(Integer id);
    ResponseDto add(RegionDto dto);
    ResponseDto update(RegionDto dto);
    ResponseDto delete(Integer id);
}
