package online.bookStore.controller;

import lombok.RequiredArgsConstructor;
import online.bookStore.dto.AuthorDto;
import online.bookStore.dto.ResponseDto;
import online.bookStore.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping
    public ResponseDto<List<AuthorDto>> getAllAuthor(){
        return authorService.getAllAuthor();
    }

    @GetMapping("/{id}")
    public ResponseDto<AuthorDto> getById(@PathVariable Integer id){
        return authorService.getWithId(id);
    }

    @PostMapping
    public ResponseDto addAuthor(@RequestBody AuthorDto authorDto){
        return authorService.addAuthor(authorDto);
    }

    @PutMapping
    public ResponseDto updateAuthor(@RequestBody AuthorDto authorDto){
        return authorService.updateAuthor(authorDto);
    }

    @DeleteMapping
    public ResponseDto deleteAuthor(@RequestParam Integer id){
        return authorService.deleteWithId(id);
    }
}
