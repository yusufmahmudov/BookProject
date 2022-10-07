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
public class Authority {
    @Id
    @GeneratedValue(generator = "authority_id_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(sequenceName = "authority_id_seq", name = "authority_id_seq",  allocationSize = 1)
    private Integer id;
    private String permission;
}
