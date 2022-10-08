package online.bookStore.service.mapper;

import online.bookStore.dto.OrderBooksDto;
import online.bookStore.entity.OrderBooks;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderBookMapper {

    OrderBooks toEntity(OrderBooksDto orderBooksDto);
    OrderBooksDto toDto(OrderBooks orderBooks);
}
