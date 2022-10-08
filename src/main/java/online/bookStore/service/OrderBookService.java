package online.bookStore.service;

import online.bookStore.dto.OrderBooksDto;
import online.bookStore.dto.OrderDto;
import online.bookStore.dto.ResponseDto;
import online.bookStore.entity.OrderBooks;

import java.util.List;

public interface OrderBookService {
    ResponseDto<List<OrderBooksDto>> getAllOrderBook();
    ResponseDto<OrderBooksDto> getById(Integer id);
    ResponseDto addOrderBook(OrderBooksDto orderBooksDto);
    ResponseDto updateOrderBook(OrderBooksDto orderBooksDto);
    ResponseDto deleteOrderBook(Integer id);

}
