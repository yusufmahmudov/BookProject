package online.bookStore.service.mapper;

import online.bookStore.dto.EBookDto;
import online.bookStore.entity.EBook;

public class EBookMapper {
    public static EBookDto toDto(EBook ebook){
        return EBookDto.builder()
                .id(ebook.getId())
                .author(AuthorMapper.toDto(ebook.getAuthor()))
                .genre(GenreMapper.toDto(ebook.getGenre()))
                .language(LanguageMapper.toDto(ebook.getLanguage()))
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
                .author(AuthorMapper.toEntity(ebook.getAuthor()))
                .genre(GenreMapper.toEntity(ebook.getGenre()))
                .language(LanguageMapper.toEntity(ebook.getLanguage()))
                .price(ebook.getPrice())
                .name(ebook.getName())
                .page(ebook.getPage())
                .publication(ebook.getPublication())
                .path(ebook.getPath())
                .build();
    }
}
