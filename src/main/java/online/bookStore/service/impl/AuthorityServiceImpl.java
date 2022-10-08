package online.bookStore.service.impl;
import lombok.RequiredArgsConstructor;
import online.bookStore.dto.AuthorityDto;
import online.bookStore.dto.ResponseDto;
import online.bookStore.entity.Authority;
import online.bookStore.repository.AuthorityRepository;
import online.bookStore.service.AuthorityService;
import online.bookStore.service.mapper.AuthorityMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {
    private final AuthorityMapper mapper;
    private final AuthorityRepository repository;

    @Override
    public ResponseDto<List<AuthorityDto>> getAllAuthority() {
        try {
            List<AuthorityDto> authorityDtos = repository.findAll()
                    .stream()
                    .map(mapper::toDto)
                    .toList();

            return ResponseDto.<List<AuthorityDto>>builder()
                    .code(0)
                    .success(true)
                    .message("OK")
                    .data(authorityDtos)
                    .build();
        } catch (Exception i){
            i.printStackTrace();

            return ResponseDto.<List<AuthorityDto>>builder()
                    .code(-1)
                    .success(false)
                    .message("NO")
                    .build();
        }
    }

    @Override
    public ResponseDto<AuthorityDto> getById(Integer id) {
        Optional<Authority> authority = repository.findById(id);

        if(authority.isPresent()){
            AuthorityDto authorityDto = mapper.toDto(authority.get());
            return ResponseDto.<AuthorityDto>builder()
                    .code(0)
                    .success(true)
                    .message("OK")
                    .data(authorityDto)
                    .build();
        }
        return ResponseDto.<AuthorityDto>builder()
                .code(-1)
                .success(false)
                .message("NO")
                .build();
    }

    @Override
    public ResponseDto addAuthority(AuthorityDto authorityDto) {
        try {
            repository.save(mapper.toEntity(authorityDto));
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
                    .message(i.getMessage())
                    .build();
        }
    }

    @Override
    public ResponseDto updateAuthority(AuthorityDto authorityDto) {
        if (repository.existsById(authorityDto.getId())){
            repository.save(mapper.toEntity(authorityDto));

            return ResponseDto.builder()
                    .code(200)
                    .success(true)
                    .message("Successfully updated")
                    .build();
        }
        return ResponseDto.builder()
                .code(-13)
                .success(false)
                .message("No such user with id = " + authorityDto.getId())
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
                .code(-13)
                .success(false)
                .message("No such user with id = " + id)
                .build();
    }
}
