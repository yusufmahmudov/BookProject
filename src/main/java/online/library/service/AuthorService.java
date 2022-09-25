package online.library.service;

import online.library.dto.AuthorDto;
import online.library.dto.BookDto;
import online.library.dto.ResponseDto;

import java.util.List;

public interface AuthorService {
    ResponseDto<List<AuthorDto>> getAllAuthor();
    ResponseDto<AuthorDto> getWithId(Integer id);
    ResponseDto addAuthor(AuthorDto authorDto);
    ResponseDto updateAuthor(AuthorDto authorDto);

    ResponseDto deleteWithId(Integer id);
}
