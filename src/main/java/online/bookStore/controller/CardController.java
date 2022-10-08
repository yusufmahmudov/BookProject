package online.bookStore.controller;

import lombok.RequiredArgsConstructor;
import online.bookStore.dto.CardDto;
import online.bookStore.dto.ResponseDto;
import online.bookStore.service.CardService;
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
