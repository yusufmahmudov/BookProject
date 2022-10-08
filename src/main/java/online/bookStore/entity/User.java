package online.bookStore.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "user_id_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(sequenceName = "user_id_seq", name = "user_id_seq", initialValue = 1, allocationSize = 1)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "birth_date")
    private Date birthDate;

    @ManyToMany
    @JoinTable(
            name = "user_authorities",
            joinColumns = @JoinColumn(name = "user_id"),
            foreignKey = @ForeignKey(name = "fk_user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id"),
            inverseForeignKey = @ForeignKey(name = "fk_authority_id")
    )
    private Set<Authority> authorities;
}
