package online.bookStore.service.mapper;

import online.bookStore.dto.OrderDto;
import online.bookStore.entity.Order;

public class OrderMapper {
    public static Order toEntity(OrderDto orderDto){
        return Order.builder()
                .id(orderDto.getId())
                .userId(orderDto.getUserId())
                .createdAt(orderDto.getCreatedAt())
                .build();
    }

    public static OrderDto toDto(Order order){
        return OrderDto.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .createdAt(order.getCreatedAt())
                .build();
    }
}
