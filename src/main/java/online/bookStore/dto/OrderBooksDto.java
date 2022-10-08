package online.bookStore.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderBooksDto {
    private Integer id;
    private Integer book_id;
    private Integer order_id;
    private Integer amount;
}
