package online.bookStore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")

public class Order {
    @Id
    @GeneratedValue(generator = "order_id_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(sequenceName = "order_id_seq", name = "order_id_seq",allocationSize = 1)
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    private Boolean payed;
    @Column(name = "created_at")
    private Date createdAt;
    @ManyToMany
    @JoinTable(
            name = "order_books",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"),
            foreignKey = @ForeignKey(name = "fk_order_id"),
            inverseForeignKey = @ForeignKey(name = "fk_book_id")
    )
    private List<Book> books;
}
