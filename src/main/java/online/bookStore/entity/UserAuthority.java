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
@Table(name = "user_authorities")
public class UserAuthority {
    @Id
    @GeneratedValue(generator = "user_authority_id_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(sequenceName = "user_authority_id_seq", name = "user_authority_id_seq", allocationSize = 1)
    private Integer id;
    private Integer user_id;
    private Integer authority_id;
}
