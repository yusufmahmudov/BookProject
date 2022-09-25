package online.library.controller;

import lombok.RequiredArgsConstructor;
import online.library.dto.LanguageDto;
import online.library.dto.ResponseDto;
import online.library.service.LanguageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/language")
@RequiredArgsConstructor
public class LanguageController {
    private final LanguageService languageService;

    @GetMapping
    public ResponseDto<List<LanguageDto>> getAll(){
        return languageService.getAllLanguage();
    }

    @GetMapping("/{id}")
    public ResponseDto<LanguageDto> getWithId(@PathVariable Integer id){
        return languageService.getWithId(id);
    }

    @PostMapping
    public ResponseDto addLanguage(@RequestBody LanguageDto languageDto){
        return languageService.addLanguage(languageDto);
    }

    @PutMapping
    public ResponseDto updateLanguage(@RequestBody LanguageDto languageDto){
        return languageService.updateLanguage(languageDto);
    }

    @DeleteMapping
    public ResponseDto deleteLanguage(@RequestParam Integer id){
        return languageService.deleteLanguage(id);
    }
}
