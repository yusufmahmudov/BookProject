package online.bookStore.service;

import online.bookStore.dto.AuthorDto;
import online.bookStore.dto.ResponseDto;

import java.util.List;

public interface AuthorService {
    ResponseDto<List<AuthorDto>> getAllAuthor();
    ResponseDto<AuthorDto> getWithId(Integer id);
    ResponseDto addAuthor(AuthorDto authorDto);
    ResponseDto updateAuthor(AuthorDto authorDto);

    ResponseDto deleteWithId(Integer id);
}
