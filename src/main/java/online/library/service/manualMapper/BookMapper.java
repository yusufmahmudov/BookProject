package online.library.service.manualMapper;

import online.library.dto.BookDto;
import online.library.entity.Book;

public class BookMapper {
    public static Book toEntity(BookDto bookDto){
        return Book.builder()
                .id(bookDto.getId())
                .name(bookDto.getName())
                .page(bookDto.getPage())
                .price(bookDto.getPrice())
                .amount(bookDto.getAmount())
                .publication(bookDto.getPublication())
                .publisherId(PublisherMapper.toEntity(bookDto.getPublisherId()))
                .languageId(LanguageMapper.toEntity(bookDto.getLanguageId()))
                .build();
    }

    public static BookDto toDto(Book book){
        return BookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .page(book.getPage())
                .price(book.getPrice())
                .amount(book.getAmount())
                .publication(book.getPublication())
                .publisherId(PublisherMapper.toDto(book.getPublisherId()))
                .languageId(LanguageMapper.toDto(book.getLanguageId()))
                .build();
    }


}
