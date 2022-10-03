package online.bookStore.controller;

import lombok.RequiredArgsConstructor;
import online.bookStore.dto.AuthorDto;
import online.bookStore.dto.ResponseDto;
import online.bookStore.dto.UserAddressDto;
import online.bookStore.service.UserAddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users_address")

public class UsersAddressController {
    private final UserAddressService userAddressService;

    @GetMapping
    public ResponseDto<List<UserAddressDto>> getAllUserAddress(){
        return userAddressService.getAllUsersAddresses();
    }

    @GetMapping("/{id}")
    public ResponseDto<UserAddressDto> getById(@PathVariable Integer id){
        return userAddressService.getById(id);
    }

    @PostMapping
    public ResponseDto add(@RequestParam String address, @RequestBody UserAddressDto userAddressDto){
        return userAddressService.add(address, userAddressDto);
    }

    @PutMapping
    public ResponseDto update(@RequestBody UserAddressDto dto){
        return userAddressService.update(dto);
    }

    @DeleteMapping
    public ResponseDto delete(@RequestParam Integer id){
        return userAddressService.delete(id);
    }
}
