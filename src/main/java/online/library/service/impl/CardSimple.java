package online.library.service.impl;

import lombok.RequiredArgsConstructor;
import online.library.dto.AuthorDto;
import online.library.dto.CardDto;
import online.library.dto.ResponseDto;
import online.library.entity.Author;
import online.library.entity.Card;
import online.library.repository.CardRepository;
import online.library.service.CardService;
import online.library.service.manualMapper.AuthorMapper;
import online.library.service.manualMapper.CardMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardSimple implements CardService {

    private final CardRepository cardRepository;

    @Override
    public ResponseDto<List<CardDto>> getAllCard() {
        try {
            List<CardDto> cards = cardRepository.findAll().stream().map(CardMapper::toDto).toList();

            return ResponseDto.<List<CardDto>>builder()
                    .code(0)
                    .success(true)
                    .message("OK")
                    .data(cards)
                    .build();
        } catch (Exception i){
            i.printStackTrace();
            return ResponseDto.<List<CardDto>>builder()
                    .code(-1)
                    .success(false)
                    .message("NO")
                    .build();
        }
    }

    @Override
    public ResponseDto<CardDto> getWithId(Integer id) {
        Optional<Card> card = cardRepository.findById(id);

        if(card.isPresent()){
            CardDto cardDto = CardMapper.toDto(card.get());
            return ResponseDto.<CardDto>builder()
                    .code(0)
                    .success(true)
                    .message("OK")
                    .data(cardDto)
                    .build();
        }
        return ResponseDto.<CardDto>builder()
                .code(-1)
                .success(false)
                .message("NO")
                .build();
    }

    @Override
    public ResponseDto addCard(CardDto cardDto) {
        try {
            cardRepository.save(CardMapper.toEntity(cardDto));
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
    public ResponseDto updateCard(CardDto cardDto) {
        try {
            cardRepository.save(CardMapper.toEntity(cardDto));
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
    public ResponseDto deleteCard(Integer id) {
        try {
            cardRepository.deleteById(id);
            return ResponseDto.builder()
                    .code(0)
                    .success(true)
                    .message("OK")
                    .build();
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.builder()
                    .code(-1)
                    .success(false)
                    .message("Was not deleted")
                    .build();
        }
    }
}
