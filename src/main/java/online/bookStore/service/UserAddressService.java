package online.bookStore.service;

import online.bookStore.dto.ResponseDto;
import online.bookStore.dto.UserAddressDto;
import online.bookStore.service.jsonBuilder.JsonBody;

import java.util.List;

public interface UserAddressService {
    ResponseDto<List<UserAddressDto>> getAllUsersAddresses();
    ResponseDto<UserAddressDto> getById(Integer id);
    ResponseDto add(String address, UserAddressDto dto);
    ResponseDto update(UserAddressDto dto);
    ResponseDto delete(Integer id);
    Integer getDistanceBetweenTwoAddress(String address);
}
