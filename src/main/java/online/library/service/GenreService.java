package online.library.service;

import online.library.dto.BookDto;
import online.library.dto.GenreDto;
import online.library.dto.ResponseDto;
import online.library.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface GenreService {
    ResponseDto<List<GenreDto>> getAllGenre();
    ResponseDto<GenreDto> getWithId(Integer id);
    ResponseDto addGenre(GenreDto genreDto);
    ResponseDto updateGenre(GenreDto genreDto);
    ResponseDto deleteGenre(Integer id);
}
