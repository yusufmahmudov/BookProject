package online.bookStore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class EBookDto {

    private Integer id;
    private String name;
    private Integer page;
    private Date publication;
    private Double price;
    private AuthorDto author;
    private GenreDto genre;
    private LanguageDto language;
    private String path;
}
