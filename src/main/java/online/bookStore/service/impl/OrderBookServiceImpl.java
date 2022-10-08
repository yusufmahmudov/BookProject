package online.bookStore.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online.bookStore.dto.OrderBooksDto;
import online.bookStore.dto.ResponseDto;
import online.bookStore.entity.OrderBooks;
import online.bookStore.repository.OrderBooksRepository;
import online.bookStore.service.OrderBookService;
import online.bookStore.service.mapper.OrderBookMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderBookServiceImpl implements OrderBookService {

    private final OrderBooksRepository orderBooksRepository;
    private final OrderBookMapper orderBookMapper;


    @Override
    public ResponseDto<List<OrderBooksDto>> getAllOrderBook() {
        List<OrderBooks> orderBooks = orderBooksRepository.findAll();

        List<OrderBooksDto> orderBooksDtos = orderBooks.stream()
                .map(orderBookMapper::toDto).toList();

        return ResponseDto.<List<OrderBooksDto>>builder()
                .data(orderBooksDtos)
                .message("OK")
                .code(0)
                .success(true)
                .build();
    }

    @Override
    public ResponseDto<OrderBooksDto> getById(Integer id) {
        Optional<OrderBooks> optional = orderBooksRepository.findById(id);

        if (optional.isPresent()){
            OrderBooksDto booksDto = orderBookMapper.toDto(optional.get());
            return ResponseDto.<OrderBooksDto>builder()
                    .data(booksDto)
                    .success(true)
                    .message("OK")
                    .code(0)
                    .build();
        }
        return ResponseDto.<OrderBooksDto>builder()
                .message("NO")
                .success(false)
                .code(-1)
                .build();
    }

    @Override
    public ResponseDto addOrderBook(OrderBooksDto orderBooksDto) {
        try {
            orderBooksRepository.save(orderBookMapper.toEntity(orderBooksDto));
            return ResponseDto.builder()
                    .code(0)
                    .success(true)
                    .message("OK")
                    .build();
        }catch (Exception e) {
            log.error(e.getMessage());
            return ResponseDto.builder()
                    .code(-1)
                    .success(false)
                    .message("NO")
                    .build();
        }
    }

    @Override
    public ResponseDto updateOrderBook(OrderBooksDto orderBooksDto) {
        try {
            orderBooksRepository.save(orderBookMapper.toEntity(orderBooksDto));
            return ResponseDto.builder()
                .code(0)
                .success(true)
                .message("UPDATED")
                .build();
        }catch (Exception e) {
            log.error(e.getMessage());
            return ResponseDto.builder()
                .code(-1)
                .success(false)
                .message("NOT UPDATED")
                .build();
       }
    }

    @Override
    public ResponseDto deleteOrderBook(Integer id) {
        if (orderBooksRepository.existsById(id)) {
            orderBooksRepository.deleteById(id);
            return ResponseDto.builder()
                    .code(0)
                    .message("DELETED")
                    .success(true)
                    .build();
        }
        return ResponseDto.builder()
                .code(-1)
                .success(false)
                .message("NOT DELETED")
                .build();
    }
}
