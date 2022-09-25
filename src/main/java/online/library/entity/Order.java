package online.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")

public class Order {

    @Id
    @GeneratedValue(generator = "order_id_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(sequenceName = "order_id_seq", name = "order_id_seq", initialValue = 1, allocationSize = 1)
    private Integer id;

    @Column(name = "total")
    private Integer total;

    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "user_id")
    private Integer userId;

}
