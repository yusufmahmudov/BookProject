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
@Table(name = "genre")

public class Genre {

    @Id
    @GeneratedValue(generator = "genre_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(sequenceName = "genre_seq", name = "genre_id_seq", initialValue = 1, allocationSize = 1)
    private Integer id;

    @Column(name = "name")
    private String name;
}
