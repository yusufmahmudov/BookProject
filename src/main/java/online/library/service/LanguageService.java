package online.library.service;

import online.library.dto.GenreDto;
import online.library.dto.LanguageDto;
import online.library.dto.ResponseDto;

import java.util.List;

public interface LanguageService {
    ResponseDto<List<LanguageDto>> getAllLanguage();
    ResponseDto<LanguageDto> getWithId(Integer id);
    ResponseDto addLanguage(LanguageDto languageDto);
    ResponseDto updateLanguage(LanguageDto languageDto);
    ResponseDto deleteLanguage(Integer id);
}
