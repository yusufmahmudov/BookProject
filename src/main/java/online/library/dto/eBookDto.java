package online.library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class eBookDto {

    private Integer id;
    private String name;
    private Integer page;
    private Date publication;

    private Integer authorId;
    private Integer genreId;
    private Integer languageId;
}
