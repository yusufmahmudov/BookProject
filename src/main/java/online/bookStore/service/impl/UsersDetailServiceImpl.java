package online.bookStore.service.impl;
import lombok.RequiredArgsConstructor;
import online.bookStore.dto.JwtResponseDto;
import online.bookStore.dto.LoginDto;
import online.bookStore.dto.ResponseDto;
import online.bookStore.dto.UserDto;
import online.bookStore.entity.User;
import online.bookStore.repository.UserRepository;
import online.bookStore.security.JwtService;
import online.bookStore.service.UserService;
import online.bookStore.service.mapper.UsersMapper;
import online.bookStore.utils.DateUtil;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersDetailServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final UsersMapper usersMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    public static Map<Integer, UserDto> userMap = new HashMap<>();


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findFirstByUsername(username).get();

        return usersMapper.toDto(user);
    }

    @Override
    public ResponseDto<List<UserDto>> getAllUser() {
        try {
            List<UserDto> users = userRepository.findAll().stream().map(usersMapper::toDto).toList();

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
            UserDto userDto = usersMapper.toDto(user.get());
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
            userRepository.save(usersMapper.toEntity(userDto));
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
            userRepository.save(usersMapper.toEntity(userDto));
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

    @Override
    public ResponseDto<JwtResponseDto> login(LoginDto loginDto) {
        User user = userRepository.findFirstByUsername(loginDto.getUsername()).orElseThrow(
                () -> new UsernameNotFoundException(
                        String.format("Users with username %s not found", loginDto.getUsername()))
        );

        if (!passwordEncoder.matches(user.getPassword(), loginDto.getUsername())){
            throw new BadCredentialsException("Password is incorrect!");
        }

        try{
            userMap.put(user.getId(), usersMapper.toDto(user));
            String token = jwtService.generateToken(String.valueOf(user.getId()));

            return ResponseDto.<JwtResponseDto>builder()
                    .code(200)
                    .success(true)
                    .message("OK")
                    .data(new JwtResponseDto(token, DateUtil.OneDay(), null))
                    .build();

        }catch (Exception e){
            return ResponseDto.<JwtResponseDto>builder()
                    .code(-12)
                    .message(e.getMessage())
                    .build();
        }
    }


    public ResponseDto<UserDto> checkToken(String token){
        Integer subject = Integer.parseInt(String.valueOf(jwtService.getClaim(token, "sub")));
        if (subject > 0){
            return ResponseDto.<UserDto>builder()
                    .code(200)
                    .message("OK")
                    .success(true)
                    .data(userMap.get(subject))
                    .build();
        }else {
            return ResponseDto.<UserDto>builder()
                    .code(-43)
                    .message("Not found")
                    .build();
        }
    }

}
