package online.library.controller;

import lombok.RequiredArgsConstructor;
import online.library.dto.GenreDto;
import online.library.dto.ResponseDto;
import online.library.repository.GenreRepository;
import online.library.service.GenreService;
import org.springframework.web.bind.annotation.*;

import java.awt.geom.RectangularShape;
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
