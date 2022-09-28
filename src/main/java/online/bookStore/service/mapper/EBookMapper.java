package online.bookStore.service.mapper;

import online.bookStore.dto.EBookDto;
import online.bookStore.entity.EBook;

public class EBookMapper {
    public static EBookDto toDto(EBook ebook){
        return EBookDto.builder()
                .id(ebook.getId())
                .authorId(AuthorMapper.toDto(ebook.getAuthorId()))
                .genreId(GenreMapper.toDto(ebook.getGenreId()))
                .languageId(LanguageMapper.toDto(ebook.getLanguageId()))
                .price(ebook.getPrice())
                .name(ebook.getName())
                .page(ebook.getPage())
                .publication(ebook.getPublication())
                .path(ebook.getPath())
                .build();
    }

    public static EBook toEntity(EBookDto ebook){
        return EBook.builder()
                .id(ebook.getId())
                .authorId(AuthorMapper.toEntity(ebook.getAuthorId()))
                .genreId(GenreMapper.toEntity(ebook.getGenreId()))
                .languageId(LanguageMapper.toEntity(ebook.getLanguageId()))
                .price(ebook.getPrice())
                .name(ebook.getName())
                .page(ebook.getPage())
                .publication(ebook.getPublication())
                .path(ebook.getPath())
                .build();
    }
}
