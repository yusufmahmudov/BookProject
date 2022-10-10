package online.bookStore.service;

import online.bookStore.dto.OrderDto;
import online.bookStore.dto.ResponseDto;

import java.util.List;

public interface OrderService {

    ResponseDto addNewOrder(Integer book_id, Integer amount);

    ResponseDto<List<OrderDto>> getAllOrder();
    ResponseDto<OrderDto> getById(Integer id);
    ResponseDto updateOrder(OrderDto orderDto);
    ResponseDto deleteOrder(Integer id);

}
