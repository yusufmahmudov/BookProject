package online.library.service;

import online.library.dto.BookDto;
import online.library.dto.ResponseDto;

import java.util.List;

public interface BookService {
    ResponseDto<List<BookDto>> getAllBook();
    ResponseDto<BookDto> getWithId(Integer id);
    ResponseDto addBook(BookDto bookDto);
    ResponseDto updateBook(BookDto bookDto);
    ResponseDto deleteBook(Integer id);
}
