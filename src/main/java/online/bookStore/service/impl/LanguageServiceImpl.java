package online.bookStore.service.impl;

import lombok.RequiredArgsConstructor;
import online.bookStore.dto.LanguageDto;
import online.bookStore.dto.ResponseDto;
import online.bookStore.entity.Language;
import online.bookStore.repository.LanguageRepository;
import online.bookStore.service.LanguageService;
import online.bookStore.service.mapper.LanguageMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    @Override
    public ResponseDto<List<LanguageDto>> getAllLanguage() {
        try {
            List<LanguageDto> languages = languageRepository.findAll().stream().map(LanguageMapper::toDto).toList();

            return ResponseDto.<List<LanguageDto>>builder()
                    .code(0)
                    .success(true)
                    .message("OK")
                    .data(languages)
                    .build();
        } catch (Exception i){
            i.printStackTrace();
            return ResponseDto.<List<LanguageDto>>builder()
                    .code(-1)
                    .success(false)
                    .message("NO")
                    .build();
        }
    }

    @Override
    public ResponseDto<LanguageDto> getWithId(Integer id) {
        Optional<Language> language = languageRepository.findById(id);

        if(language.isPresent()){
            LanguageDto languageDto = LanguageMapper.toDto(language.get());
            return ResponseDto.<LanguageDto>builder()
                    .code(0)
                    .success(true)
                    .message("OK")
                    .data(languageDto)
                    .build();
        }
        return ResponseDto.<LanguageDto>builder()
                .code(-1)
                .success(false)
                .message("NO")
                .build();
    }

    @Override
    public ResponseDto addLanguage(LanguageDto languageDto) {
        try {
            languageRepository.save(LanguageMapper.toEntity(languageDto));
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
    public ResponseDto updateLanguage(LanguageDto languageDto) {
        try {
            languageRepository.save(LanguageMapper.toEntity(languageDto));
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
    public ResponseDto deleteLanguage(Integer id) {
        try {
            languageRepository.deleteById(id);
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
