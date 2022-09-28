package online.bookStore.service;

import online.bookStore.dto.LanguageDto;
import online.bookStore.dto.ResponseDto;

import java.util.List;

public interface LanguageService {
    ResponseDto<List<LanguageDto>> getAllLanguage();
    ResponseDto<LanguageDto> getWithId(Integer id);
    ResponseDto addLanguage(LanguageDto languageDto);
    ResponseDto updateLanguage(LanguageDto languageDto);
    ResponseDto deleteLanguage(Integer id);
}
