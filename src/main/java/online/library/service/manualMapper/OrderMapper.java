package online.library.service.manualMapper;

import online.library.dto.OrderDto;
import online.library.entity.Order;
import org.aspectj.weaver.ast.Or;

public class OrderMapper {
    public static Order toEntity(OrderDto orderDto){
        return Order.builder()
                .id(orderDto.getId())
                .total(orderDto.getTotal())
                .userId(orderDto.getUserId())
                .createdAt(orderDto.getCreatedAt())
                .build();
    }

    public static OrderDto toDto(Order order){
        return OrderDto.builder()
                .id(order.getId())
                .total(order.getTotal())
                .userId(order.getUserId())
                .createdAt(order.getCreatedAt())
                .build();
    }
}
