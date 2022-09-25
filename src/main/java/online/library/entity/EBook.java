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

public class EBook {

    @Id
    @GeneratedValue(generator = "e_book_id_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(sequenceName = "e_book_id_seq", name = "e_book_id_seq", initialValue = 1, allocationSize = 1)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "page")
    private Integer page;

    @Column(name = "publication")
    private Date publication;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author authorId;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genreId;
    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language languageId;


}
