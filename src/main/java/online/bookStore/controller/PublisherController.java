package online.bookStore.controller;

import lombok.RequiredArgsConstructor;
import online.bookStore.dto.PublisherDto;
import online.bookStore.dto.ResponseDto;
import online.bookStore.service.PublisherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher")
@RequiredArgsConstructor
public class PublisherController {
    private final PublisherService publisherService;

    @GetMapping
    public ResponseDto<List<PublisherDto>> getAllPublisher(){
        return publisherService.getAllPublisher();
    }

    @GetMapping("/{id}")
    public ResponseDto<PublisherDto> getWithId(@PathVariable Integer id){
        return publisherService.getWithId(id);
    }

    @PostMapping
    public ResponseDto addPublisher(@RequestBody PublisherDto publisherDto){
        return publisherService.addPublisher(publisherDto);
    }

    @PutMapping
    public ResponseDto updatePublisher(@RequestBody PublisherDto publisherDto){
        return publisherService.updatePublisher(publisherDto);
    }

    @DeleteMapping
    public ResponseDto deletePublisher(@RequestParam Integer id){
        return publisherService.deletePublisher(id);
    }
}
