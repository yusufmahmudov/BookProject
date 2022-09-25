package online.library.service.manualMapper;

import online.library.dto.GenreDto;
import online.library.entity.Genre;

public class GenreMapper {
    public static Genre toEntity(GenreDto genreDto){
        return Genre.builder()
                .id(genreDto.getId())
                .name(genreDto.getName())
                .build();
    }

    public static GenreDto toDto(Genre genre){
        return GenreDto.builder()
                .id(genre.getId())
                .name(genre.getName())
                .build();
    }
}
