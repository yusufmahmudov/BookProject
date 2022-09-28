package online.bookStore.service;

import online.bookStore.dto.CityDto;
import online.bookStore.dto.ResponseDto;
import online.bookStore.dto.UserAddressDto;

import java.util.List;
public interface CityService {
    ResponseDto<List<CityDto>> getAllCities();
    ResponseDto<CityDto> getById(Integer id);
    ResponseDto add(CityDto dto);
    ResponseDto update(CityDto dto);
    ResponseDto delete(Integer id);
}
