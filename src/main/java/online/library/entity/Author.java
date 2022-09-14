package online.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "author")

public class Author {

    @Id
    @GeneratedValue(generator = "author_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(sequenceName = "author_seq", name = "author_id_seq", initialValue = 1, allocationSize = 1)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

}
