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
@Table(name = "order_books")
public class OrderBooks {
    @Id
    @GeneratedValue(generator = "order_books_id_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(sequenceName = "order_books_id_seq", name = "order_books_id_seq", allocationSize = 1)
    private Integer id;
    private Integer book_id;
    private Integer order_id;
    private Integer amount;
}
