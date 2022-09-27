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
public class Admin {

    @Id
    @GeneratedValue(generator = "admin_id_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(sequenceName = "admin_id_seq", name = "admin_id_seq", initialValue = 1, allocationSize = 1)
    private Integer id;

    @Column(name = "full_name")
    private String fullName;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String username;
    private String password;

    private Double account;


}
