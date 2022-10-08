package online.bookStore.controller;

import lombok.RequiredArgsConstructor;
import online.bookStore.dto.ResponseDto;
import online.bookStore.dto.UserAddressDto;
import online.bookStore.service.impl.UsersAddressServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-address")
public class UserAddressController {

    private final UsersAddressServiceImpl usersAddressService;

    @GetMapping("/all")
    public ResponseDto<List<UserAddressDto>> getAllUsersAddresses(){
        return usersAddressService.getAllUsersAddresses();
    }

    @GetMapping("/{id}")
    public ResponseDto<UserAddressDto> getById(@PathVariable Integer id){
        return usersAddressService.getById(id);
    }

    @PostMapping("/add")
    public ResponseDto addUserAddress(@RequestParam String address, @RequestBody UserAddressDto dto){
        return usersAddressService.add(address, dto);
    }

    @PutMapping
    public ResponseDto updateUserAddress(@RequestBody UserAddressDto userAddressDto){
        return usersAddressService.update(userAddressDto);
    }

    @DeleteMapping
    public ResponseDto deleteUserAddress(@RequestParam Integer id){
        return usersAddressService.delete(id);
    }
}
