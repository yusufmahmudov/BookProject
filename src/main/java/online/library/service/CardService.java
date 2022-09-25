package online.library.service;

import online.library.dto.AuthorDto;
import online.library.dto.CardDto;
import online.library.dto.ResponseDto;

import java.util.List;

public interface CardService {
    ResponseDto<List<CardDto>> getAllCard();
    ResponseDto<CardDto> getWithId(Integer id);
    ResponseDto addCard(CardDto cardDto);
    ResponseDto updateCard(CardDto cardDto);
    ResponseDto deleteCard(Integer id);
}
