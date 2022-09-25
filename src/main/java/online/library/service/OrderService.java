package online.library.service;

import online.library.dto.LanguageDto;
import online.library.dto.OrderDto;
import online.library.dto.ResponseDto;

import java.util.List;

public interface OrderService {
    ResponseDto<List<OrderDto>> getAllOrder();
    ResponseDto<OrderDto> getWithId(Integer id);
    ResponseDto addOrder(OrderDto orderDto);
    ResponseDto updateOrder(OrderDto orderDto);
    ResponseDto deleteOrder(Integer id);
}
