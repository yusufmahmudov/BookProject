package online.bookStore.service.mapper;

import online.bookStore.dto.AuthorDto;
import online.bookStore.entity.Author;

public class AuthorMapper {
    public static AuthorDto toDto(Author author){
        return AuthorDto.builder()
                .id(author.getId())
                .firstName(author.getFirstName())
                .lastName(author.getLastName())
                .build();
    }

    public static Author toEntity(AuthorDto authorDto){
        return Author.builder()
                .id(authorDto.getId())
                .firstName(authorDto.getFirstName())
                .lastName(authorDto.getLastName())
                .build();
    }
}
