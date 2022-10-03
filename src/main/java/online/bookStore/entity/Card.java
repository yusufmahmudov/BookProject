package online.bookStore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(generator = "card_id_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(sequenceName = "card_id_seq", name = "card_id_seq", initialValue = 1, allocationSize = 1)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private User user;

    @Column(name = "card_number")
    private String cardNumber;
    private Date valid_date;
    private Double account;
}
