package online.bookStore.controller;

import lombok.RequiredArgsConstructor;
import online.bookStore.dto.BookDto;
import online.bookStore.dto.ResponseDto;
import online.bookStore.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseDto<List<BookDto>> getAll(){
        return bookService.getAllBook();
    }

    @PutMapping
    public ResponseDto updateBook(@RequestBody BookDto bookDto){
        return bookService.updateBook(bookDto);
    }

    @PostMapping
    public ResponseDto addBook(@RequestBody BookDto bookDto){
        return bookService.addBook(bookDto);
    }

    @GetMapping("/{id}")
    public ResponseDto<BookDto> getWithId(@PathVariable Integer id){
        return bookService.getWithId(id);
    }

    @DeleteMapping
    public ResponseDto deleteBook(@RequestParam Integer id){
        return bookService.deleteBook(id);
    }
}
