package online.library.service.impl;

import lombok.RequiredArgsConstructor;
import online.library.dto.LanguageDto;
import online.library.dto.ResponseDto;
import online.library.entity.Language;
import online.library.repository.LanguageRepository;
import online.library.service.LanguageService;
import online.library.service.manualMapper.LanguageMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LanguageSimple implements LanguageService {

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
