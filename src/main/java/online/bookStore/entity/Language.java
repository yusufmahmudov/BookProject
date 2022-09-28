package online.bookStore.entity;

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
@Table(name = "language")

public class Language {

    @Id
    @GeneratedValue(generator = "language_id_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(sequenceName = "language_id_seq", name = "language_id_seq", initialValue = 1, allocationSize = 1)
    private Integer id;

    @Column(name = "name")
    private String name;

}
