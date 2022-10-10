package online.bookStore.service.mapper;

import online.bookStore.dto.OrderDto;
import online.bookStore.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrdersMapper {
    Order toEntity(OrderDto orderDto);
    OrderDto toDto(Order order);
}
