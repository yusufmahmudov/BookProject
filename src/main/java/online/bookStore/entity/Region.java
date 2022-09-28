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
public class Region {
    @Id
    @GeneratedValue(generator = "region_id_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(sequenceName = "region_id_seq", name = "region_id_seq",allocationSize = 1)
    private Integer id;
    private String name;
}
