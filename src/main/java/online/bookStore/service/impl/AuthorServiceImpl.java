package online.bookStore.service.impl;

import lombok.RequiredArgsConstructor;
import online.bookStore.dto.AuthorDto;
import online.bookStore.dto.ResponseDto;
import online.bookStore.entity.Author;
import online.bookStore.repository.AuthorRepository;
import online.bookStore.service.AuthorService;
import online.bookStore.service.mapper.AuthorMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;


    @Override
    public ResponseDto<List<AuthorDto>> getAllAuthor() {
        try {
            List<AuthorDto> books = authorRepository.findAll().stream().map(AuthorMapper::toDto).toList();

            return ResponseDto.<List<AuthorDto>>builder()
                    .code(0)
                    .success(true)
                    .message("OK")
                    .data(books)
                    .build();
        } catch (Exception i){
            i.printStackTrace();
            return ResponseDto.<List<AuthorDto>>builder()
                    .code(-1)
                    .success(false)
                    .message("NO")
                    .build();
        }
    }

    @Override
    public ResponseDto<AuthorDto> getWithId(Integer id) {
        Optional<Author> author = authorRepository.findById(id);

        if(author.isPresent()){
            AuthorDto authorDto = AuthorMapper.toDto(author.get());
            return ResponseDto.<AuthorDto>builder()
                    .code(0)
                    .success(true)
                    .message("OK")
                    .data(authorDto)
                    .build();
        }
        return ResponseDto.<AuthorDto>builder()
                .code(-1)
                .success(false)
                .message("NO")
                .build();
    }

    @Override
    public ResponseDto addAuthor(AuthorDto authorDto) {
        try {
            authorRepository.save(AuthorMapper.toEntity(authorDto));
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
    public ResponseDto updateAuthor(AuthorDto authorDto) {
        try {
            Optional<Author> author = authorRepository.findById(authorDto.getId());

            AuthorDto authorDto2 = new AuthorDto();
            if(author.isPresent()){ authorDto2 = AuthorMapper.toDto(author.get()); }

            if(authorDto.getFirstName() == null) authorDto.setFirstName(authorDto2.getFirstName());
            if(authorDto.getLastName() == null) authorDto.setLastName(authorDto2.getLastName());

            authorRepository.save(AuthorMapper.toEntity(authorDto));
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
    public ResponseDto deleteWithId(Integer id) {
        try {
            authorRepository.deleteById(id);
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
                    .message(i.getMessage())
                    .build();
        }
    }
}
