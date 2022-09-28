package online.bookStore.service;

import online.bookStore.dto.OrderDto;
import online.bookStore.dto.ResponseDto;

import java.util.List;

public interface OrderService {
    ResponseDto<List<OrderDto>> getAllOrder();
    ResponseDto<OrderDto> getWithId(Integer id);
    ResponseDto addOrder(OrderDto orderDto);
    ResponseDto updateOrder(OrderDto orderDto);
    ResponseDto deleteOrder(Integer id);
}
