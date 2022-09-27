package online.library.controller;

import lombok.RequiredArgsConstructor;
import online.library.dto.EBookDto;
import online.library.dto.ResponseDto;
import online.library.service.EBookService;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eBook")
@RequiredArgsConstructor
public class EBookController {

    private final EBookService eBookService;

    @GetMapping
    public ResponseDto<List<EBookDto>> getAll(){
        return eBookService.getAllEBook();
    }

    @GetMapping("/pdf")
    public ResponseEntity<Resource> download(@RequestParam Integer id){
        return eBookService.download(id);
    }

    @GetMapping("/{id}")
    public ResponseDto<EBookDto> getWithId(@PathVariable Integer id){
        return eBookService.getWithId(id);
    }

    @PostMapping
    public ResponseDto addEBook(@RequestBody EBookDto eBookDto){
        return eBookService.addEBook(eBookDto);
    }

    @PutMapping
    public ResponseDto updateEBook(@RequestBody EBookDto eBookDto){
        return eBookService.updateEBook(eBookDto);
    }

    @DeleteMapping
    public ResponseDto deleteEBook(@RequestParam Integer id){ return eBookService.deleteEBook(id); }
}
