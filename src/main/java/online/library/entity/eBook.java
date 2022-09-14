package online.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "e_book")

public class eBook {

    @Id
    @GeneratedValue(generator = "e_book_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(sequenceName = "e_book_seq", name = "e_book_id_seq", initialValue = 1, allocationSize = 1)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "page")
    private Integer page;

    @Column(name = "publication")
    private Date publication;

    private Integer authorId;
    private Integer genreId;
    private Integer languageId;


}
