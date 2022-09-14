package online.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "gender")

public class Gender {

    @Id
    @GeneratedValue(generator = "gender_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(sequenceName = "gender_seq", name = "gender_id_seq", initialValue = 1, allocationSize = 1)
    private Integer id;

    @Column(name = "name")
    private String name;

}
