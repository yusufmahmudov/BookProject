package online.library.service.manualMapper;

import online.library.dto.CardDto;
import online.library.entity.Card;

public class CardMapper {
    public static Card toEntity(CardDto cardDto){
        return Card.builder()
                .id(cardDto.getId())
                .name(cardDto.getName())
                .cardNumber(cardDto.getCardNumber())
                .date(cardDto.getDate())
                .build();
    }

    public static CardDto toDto(Card card){
        return CardDto.builder()
                .id(card.getId())
                .name(card.getName())
                .cardNumber(card.getCardNumber())
                .date(card.getDate())
                .build();
    }
}
