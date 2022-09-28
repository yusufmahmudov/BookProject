package online.bookStore.service;

import online.bookStore.dto.BookDto;
import online.bookStore.dto.ResponseDto;

import java.util.List;

public interface BookService {
    ResponseDto<List<BookDto>> getAllBook();
    ResponseDto<BookDto> getWithId(Integer id);
    ResponseDto addBook(BookDto bookDto);
    ResponseDto updateBook(BookDto bookDto);
    ResponseDto deleteBook(Integer id);
}
