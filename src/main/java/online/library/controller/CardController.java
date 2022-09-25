package online.library.controller;

import lombok.RequiredArgsConstructor;
import online.library.dto.CardDto;
import online.library.dto.ResponseDto;
import online.library.service.CardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/card")
public class CardController {
    private final CardService cardService;

    @GetMapping
    public ResponseDto<List<CardDto>> getAll(){
        return cardService.getAllCard();
    }

    @GetMapping("/{id}")
    public ResponseDto<CardDto> getWithId(@PathVariable Integer id){
        return cardService.getWithId(id);
    }

    @PostMapping
    public ResponseDto addCard(@RequestBody CardDto cardDto){
        return cardService.addCard(cardDto);
    }

    @PutMapping
    public ResponseDto updateCard(@RequestBody CardDto cardDto){
        return cardService.updateCard(cardDto);
    }

    @DeleteMapping
    public ResponseDto deleteCard(@RequestParam Integer id){
        return cardService.deleteCard(id);
    }
}
