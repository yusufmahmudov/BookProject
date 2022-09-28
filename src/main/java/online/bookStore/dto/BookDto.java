package online.bookStore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Integer id;
    private String name;
    private Integer amount;
    private Double price;
    private Integer page;
    private Date publication;
    private AuthorDto author;
    private GenreDto genre;
    private LanguageDto language;
    private PublisherDto publisher;
}
