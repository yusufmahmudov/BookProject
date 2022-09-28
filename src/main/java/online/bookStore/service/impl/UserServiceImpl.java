package online.bookStore.service.impl;

import lombok.RequiredArgsConstructor;
import online.bookStore.dto.ResponseDto;
import online.bookStore.dto.UserDto;
import online.bookStore.entity.User;
import online.bookStore.repository.UserRepository;
import online.bookStore.service.UserService;
import online.bookStore.service.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public ResponseDto<List<UserDto>> getAllUser() {
        try {
            List<UserDto> users = userRepository.findAll().stream().map(UserMapper::toDto).toList();

            return ResponseDto.<List<UserDto>>builder()
                    .code(0)
                    .success(true)
                    .message("OK")
                    .data(users)
                    .build();
        } catch (Exception i){
            i.printStackTrace();
            return ResponseDto.<List<UserDto>>builder()
                    .code(-1)
                    .success(false)
                    .message("NO")
                    .build();
        }
    }

    @Override
    public ResponseDto<UserDto> getWithId(Integer id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){
            UserDto userDto = UserMapper.toDto(user.get());
            return ResponseDto.<UserDto>builder()
                    .code(0)
                    .success(true)
                    .message("OK")
                    .data(userDto)
                    .build();
        }
        return ResponseDto.<UserDto>builder()
                .code(-1)
                .success(false)
                .message("NO")
                .build();
    }

    @Override
    public ResponseDto addUser(UserDto userDto) {
        try {
            userRepository.save(UserMapper.toEntity(userDto));
            return ResponseDto.builder()
                    .code(0)
                    .success(true)
                    .message("Saved")
                    .build();
        } catch (Exception i){
            i.printStackTrace();
            return ResponseDto.builder()
                    .code(-1)
                    .success(false)
                    .message("NO")
                    .build();
        }
    }

    @Override
    public ResponseDto updateUser(UserDto userDto) {
        try {
            userRepository.save(UserMapper.toEntity(userDto));
            return ResponseDto.builder()
                    .code(0)
                    .success(true)
                    .message("Updated")
                    .build();
        } catch (Exception i){
            i.printStackTrace();
            return ResponseDto.builder()
                    .code(-1)
                    .success(false)
                    .message("NO")
                    .build();
        }
    }

    @Override
    public ResponseDto deleteUser(Integer id) {
        try {
            userRepository.deleteById(id);
            return ResponseDto.builder()
                    .code(0)
                    .success(true)
                    .message("OK")
                    .build();
        } catch (Exception i){
            i.printStackTrace();
            return ResponseDto.builder()
                    .code(-1)
                    .success(false)
                    .message("Was not deleted")
                    .build();
        }
    }
}
