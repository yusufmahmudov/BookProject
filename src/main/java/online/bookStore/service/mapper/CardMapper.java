package online.bookStore.service.mapper;

import online.bookStore.dto.CardDto;
import online.bookStore.entity.Card;

public class CardMapper {
    public static Card toEntity(CardDto cardDto){
        return Card.builder()
                .id(cardDto.getId())
                .name(cardDto.getName())
                .cardNumber(cardDto.getCardNumber())
                .valid_date(cardDto.getValid_date())
                .build();
    }

    public static CardDto toDto(Card card){
        return CardDto.builder()
                .id(card.getId())
                .name(card.getName())
                .cardNumber(card.getCardNumber())
                .valid_date(card.getValid_date())
                .build();
    }
}
