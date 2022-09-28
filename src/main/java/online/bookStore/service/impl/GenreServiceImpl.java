package online.bookStore.service.impl;

import lombok.RequiredArgsConstructor;
import online.bookStore.dto.GenreDto;
import online.bookStore.dto.ResponseDto;
import online.bookStore.entity.Genre;
import online.bookStore.repository.GenreRepository;
import online.bookStore.service.GenreService;
import online.bookStore.service.mapper.GenreMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public ResponseDto<List<GenreDto>> getAllGenre() {
        try {
            List<GenreDto> genreDto = genreRepository.findAll().stream().map(GenreMapper::toDto).toList();

            return ResponseDto.<List<GenreDto>>builder()
                    .code(0)
                    .success(true)
                    .message("OK")
                    .data(genreDto)
                    .build();
        } catch (Exception i){
            i.printStackTrace();
            return ResponseDto.<List<GenreDto>>builder()
                    .code(-1)
                    .success(false)
                    .message("NO")
                    .build();
        }
    }

    @Override
    public ResponseDto<GenreDto> getWithId(Integer id) {
        Optional<Genre> genre = genreRepository.findById(id);

        if(genre.isPresent()){
            GenreDto genreDto = GenreMapper.toDto(genre.get());
            return ResponseDto.<GenreDto>builder()
                    .code(0)
                    .success(true)
                    .message("OK")
                    .data(genreDto)
                    .build();
        }
        return ResponseDto.<GenreDto>builder()
                .code(-1)
                .success(false)
                .message("NO")
                .build();
    }

    @Override
    public ResponseDto addGenre(GenreDto genreDto) {
        try {
            genreRepository.save(GenreMapper.toEntity(genreDto));
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
    public ResponseDto updateGenre(GenreDto genreDto) {
        try {
            genreRepository.save(GenreMapper.toEntity(genreDto));
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
    public ResponseDto deleteGenre(Integer id) {
        try {
            genreRepository.deleteById(id);
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
