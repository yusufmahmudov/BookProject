package online.library.service.manualMapper;

import online.library.dto.AuthorDto;
import online.library.entity.Author;

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
