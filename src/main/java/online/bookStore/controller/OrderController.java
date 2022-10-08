package online.bookStore.controller;

import lombok.RequiredArgsConstructor;
import online.bookStore.dto.OrderDto;
import online.bookStore.dto.ResponseDto;
import online.bookStore.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public ResponseDto<List<OrderDto>> getAllOrder(){
        return orderService.getAllOrder();
    }

    @GetMapping("/{id}")
    public ResponseDto<OrderDto> getOrderWithId(@PathVariable Integer id){
        return orderService.getById(id);
    }

    @PostMapping
    public ResponseDto addOrder(@RequestBody OrderDto orderDto){
        return orderService.addOrder(orderDto);
    }

    @PutMapping
    public ResponseDto updateOrder(@RequestBody OrderDto orderDto){
        return orderService.updateOrder(orderDto);
    }

    @DeleteMapping
    public ResponseDto deleteOrder(@RequestParam Integer id){
        return orderService.deleteOrder(id);
    }
}
