package online.library.service.impl;

import lombok.RequiredArgsConstructor;
import online.library.dto.BookDto;
import online.library.dto.ResponseDto;
import online.library.entity.Book;
import online.library.repository.BookRepository;
import online.library.service.BookService;
import online.library.service.manualMapper.BookMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookSimple implements BookService {
    private final BookRepository bookRepository;


    @Override
    public ResponseDto<List<BookDto>> getAllBook() {
        try {
            List<BookDto> bookDto = bookRepository.findAll().stream().map(BookMapper::toDto).toList();

            return ResponseDto.<List<BookDto>>builder()
                    .code(0)
                    .success(true)
                    .message("OK")
                    .data(bookDto)
                    .build();
        } catch (Exception i){
            i.printStackTrace();
            return ResponseDto.<List<BookDto>>builder()
                    .code(-1)
                    .success(false)
                    .message("NO")
                    .build();
        }
    }

    @Override
    public ResponseDto<BookDto> getWithId(Integer id) {
        Optional<Book> bookDto = bookRepository.findById(id);

        if(bookDto.isPresent()){
            BookDto bookD = BookMapper.toDto(bookDto.get());
            return ResponseDto.<BookDto>builder()
                    .code(0)
                    .success(true)
                    .message("OK")
                    .data(bookD)
                    .build();
        }
        return ResponseDto.<BookDto>builder()
                .code(-1)
                .success(false)
                .message("NO")
                .build();



    }

    @Override
    public ResponseDto addBook(BookDto bookDto) {
        try {
            bookRepository.save(BookMapper.toEntity(bookDto));
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
    public ResponseDto updateBook(BookDto bookDto) {
        try {
            bookRepository.save(BookMapper.toEntity(bookDto));
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
    public ResponseDto deleteBook(Integer id) {
        try {
            bookRepository.deleteById(id);
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
