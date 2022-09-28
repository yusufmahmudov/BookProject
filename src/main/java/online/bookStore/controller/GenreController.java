package online.bookStore.controller;

import lombok.RequiredArgsConstructor;
import online.bookStore.dto.GenreDto;
import online.bookStore.dto.ResponseDto;
import online.bookStore.service.GenreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
@RequiredArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @GetMapping
    public ResponseDto<List<GenreDto>> getAll(){
        return genreService.getAllGenre();
    }

    @GetMapping("/{id}")
    public ResponseDto<GenreDto> getWithId(@PathVariable Integer id){
        return genreService.getWithId(id);
    }

    @PostMapping
    public ResponseDto addGenre(@RequestBody GenreDto genreDto){
        return genreService.addGenre(genreDto);
    }

    @PutMapping
    public ResponseDto updateGenre(@RequestBody GenreDto genreDto){
        return genreService.updateGenre(genreDto);
    }

    @DeleteMapping
    public ResponseDto deleteGenre(@RequestParam Integer id){ return genreService.deleteGenre(id); }
}
