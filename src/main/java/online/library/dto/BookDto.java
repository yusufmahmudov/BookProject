package online.library.dto;

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
    private Integer authorId;
    private Integer genreId;
    private Integer languageId;
    private Integer publisherId;

}
