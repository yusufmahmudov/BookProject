package online.bookStore.service;

import online.bookStore.dto.CardDto;
import online.bookStore.dto.ResponseDto;

import java.util.List;

public interface CardService {
    ResponseDto<List<CardDto>> getAllCard();
    ResponseDto<CardDto> getWithId(Integer id);
    ResponseDto addCard(CardDto cardDto);
    ResponseDto updateCard(CardDto cardDto);
    ResponseDto deleteCard(Integer id);
}
