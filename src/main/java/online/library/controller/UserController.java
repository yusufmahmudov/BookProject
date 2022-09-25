package online.library.controller;

import lombok.RequiredArgsConstructor;
import online.library.dto.PublisherDto;
import online.library.dto.ResponseDto;
import online.library.dto.UserDto;
import online.library.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseDto<List<UserDto>> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public ResponseDto<UserDto> getWithId(@PathVariable Integer id){
        return userService.getWithId(id);
    }

    @PostMapping
    public ResponseDto addUser(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }

    @PutMapping
    public ResponseDto updateUser(@RequestBody UserDto userDto){
        return userService.updateUser(userDto);
    }

    @DeleteMapping
    public ResponseDto deleteUser(@RequestParam Integer id){
        return userService.deleteUser(id);
    }
}
