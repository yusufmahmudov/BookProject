package online.bookStore.entity;

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
@Table(name = "publisher")

public class Publisher {

    @Id
    @GeneratedValue(generator = "publisher_id_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(sequenceName = "publisher_id_seq", name = "publisher_id_seq", initialValue = 1, allocationSize = 1)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

}
