package online.bookStore.repository;
import online.bookStore.entity.OrderBooks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderBooksRepository extends JpaRepository<OrderBooks, Integer> {

}
