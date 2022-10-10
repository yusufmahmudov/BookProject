package online.bookStore.service;

import online.bookStore.dto.OrderBooksDto;
import online.bookStore.dto.ResponseDto;

import java.util.List;
public interface OrderBookService {
    ResponseDto<List<OrderBooksDto>> getAllOrderBook();
    ResponseDto<OrderBooksDto> getById(Integer id);
    ResponseDto addOrderBooks(Integer order_id, Integer book_id, Integer amount);
    ResponseDto updateOrderBook(OrderBooksDto orderBooksDto);
    ResponseDto deleteOrderBook(Integer id);

}
