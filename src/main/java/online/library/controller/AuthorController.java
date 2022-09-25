package online.library.controller;

import lombok.RequiredArgsConstructor;
import online.library.LibraryApplication;
import online.library.dto.AuthorDto;
import online.library.dto.ResponseDto;
import online.library.service.AuthorService;
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
