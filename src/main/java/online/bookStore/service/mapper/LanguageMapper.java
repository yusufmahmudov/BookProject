package online.bookStore.service.mapper;

import online.bookStore.dto.LanguageDto;
import online.bookStore.entity.Language;

public class LanguageMapper {
    public static Language toEntity(LanguageDto languageDto){
        return Language.builder()
                .id(languageDto.getId())
                .name(languageDto.getName())
                .build();
    }

    public static LanguageDto toDto(Language language){
        return LanguageDto.builder()
                .id(language.getId())
                .name(language.getName())
                .build();
    }
}
