package online.bookStore.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import online.bookStore.dto.OrderBooksDto;
import online.bookStore.dto.ResponseDto;
import online.bookStore.service.OrderBookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order-book")
public class OrderBooksController {

    private final OrderBookService orderBookService;

    @GetMapping("/all")
    public ResponseDto<List<OrderBooksDto>> getAllOrderBook(){
        return orderBookService.getAllOrderBook();
    }

    @GetMapping("/{id}")
    public ResponseDto<OrderBooksDto> getById(@PathVariable Integer id){
        return orderBookService.getById(id);
    }

    @PutMapping
    public ResponseDto updateOrderBook(@RequestBody OrderBooksDto orderBooksDto){
        return orderBookService.updateOrderBook(orderBooksDto);
    }

    @DeleteMapping
    public ResponseDto deleteOrderBook(@RequestParam Integer id){
        return orderBookService.deleteOrderBook(id);
    }


}
