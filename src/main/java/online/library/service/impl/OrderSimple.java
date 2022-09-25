package online.library.service.impl;

import lombok.RequiredArgsConstructor;
import online.library.dto.LanguageDto;
import online.library.dto.OrderDto;
import online.library.dto.ResponseDto;
import online.library.entity.Language;
import online.library.entity.Order;
import online.library.repository.OrderRepository;
import online.library.service.OrderService;
import online.library.service.manualMapper.LanguageMapper;
import online.library.service.manualMapper.OrderMapper;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderSimple implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public ResponseDto<List<OrderDto>> getAllOrder() {
        try {
            List<OrderDto> orders = orderRepository.findAll().stream().map(OrderMapper::toDto).toList();

            return ResponseDto.<List<OrderDto>>builder()
                    .code(0)
                    .success(true)
                    .message("OK")
                    .data(orders)
                    .build();
        } catch (Exception i){
            i.printStackTrace();
            return ResponseDto.<List<OrderDto>>builder()
                    .code(-1)
                    .success(false)
                    .message("NO")
                    .build();
        }
    }

    @Override
    public ResponseDto<OrderDto> getWithId(Integer id) {
        Optional<Order> order = orderRepository.findById(id);

        if(order.isPresent()){
            OrderDto orderDto = OrderMapper.toDto(order.get());
            return ResponseDto.<OrderDto>builder()
                    .code(0)
                    .success(true)
                    .message("OK")
                    .data(orderDto)
                    .build();
        }
        return ResponseDto.<OrderDto>builder()
                .code(-1)
                .success(false)
                .message("NO")
                .build();
    }

    @Override
    public ResponseDto addOrder(OrderDto orderDto) {
        try {
            orderRepository.save(OrderMapper.toEntity(orderDto));
            return ResponseDto.builder()
                    .code(0)
                    .success(true)
                    .message("Saved")
                    .build();
        } catch (Exception i){
            i.printStackTrace();
            return ResponseDto.builder()
                    .code(-1)
                    .success(false)
                    .message("NO")
                    .build();
        }
    }

    @Override
    public ResponseDto updateOrder(OrderDto orderDto) {
        try {
            orderRepository.save(OrderMapper.toEntity(orderDto));
            return ResponseDto.builder()
                    .code(0)
                    .success(true)
                    .message("Updated")
                    .build();
        } catch (Exception i){
            i.printStackTrace();
            return ResponseDto.builder()
                    .code(-1)
                    .success(false)
                    .message("NO")
                    .build();
        }
    }

    @Override
    public ResponseDto deleteOrder(Integer id) {
        try {
            orderRepository.deleteById(id);
            return ResponseDto.builder()
                    .code(0)
                    .success(true)
                    .message("OK")
                    .build();
        } catch (Exception i){
            i.printStackTrace();
            return ResponseDto.builder()
                    .code(-1)
                    .success(false)
                    .message("Was not deleted")
                    .build();
        }
    }
}
