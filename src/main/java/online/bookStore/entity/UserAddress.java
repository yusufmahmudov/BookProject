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
public class UserAddress {
    @GeneratedValue(generator = "user_address_id_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(sequenceName = "user_address_id_seq", name = "user_address_id_seq",allocationSize = 1)
    @Id
    private Integer id;

    @ManyToOne
    @Column(name = "user_id")
    private User user;

    @ManyToOne
    @Column(name = "city_id")
    private City city;

    @ManyToOne
    @Column(name = "region_id")
    private Region region;

    private String name_street;

    private Integer number_house;
    @Column(name = "distance_from_bookstore")
    private Integer distanceFromBookstore;
}
