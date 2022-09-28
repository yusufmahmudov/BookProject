package online.bookStore.service;

import online.bookStore.dto.GenreDto;
import online.bookStore.dto.ResponseDto;

import java.util.List;

public interface GenreService {
    ResponseDto<List<GenreDto>> getAllGenre();
    ResponseDto<GenreDto> getWithId(Integer id);
    ResponseDto addGenre(GenreDto genreDto);
    ResponseDto updateGenre(GenreDto genreDto);
    ResponseDto deleteGenre(Integer id);
}
