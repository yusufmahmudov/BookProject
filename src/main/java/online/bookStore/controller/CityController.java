package online.bookStore.controller;

import lombok.RequiredArgsConstructor;
import online.bookStore.dto.CityDto;
import online.bookStore.dto.ResponseDto;
import online.bookStore.service.impl.CityServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/city")
public class CityController {

    private final CityServiceImpl cityService;

    @GetMapping("/all")
    public ResponseDto<List<CityDto>> getAllCities(){
        return cityService.getAllCities();
    }

    @GetMapping("/{id}")
    public ResponseDto<CityDto> getById(@PathVariable Integer id){
        return cityService.getById(id);
    }

    @PostMapping("/add")
    public ResponseDto add(@RequestBody CityDto dto){
        return cityService.add(dto);
    }

    @PutMapping
    public ResponseDto update(@RequestBody CityDto dto){
        return cityService.update(dto);
    }

    @DeleteMapping
    public ResponseDto delete(@RequestParam Integer id){
        return cityService.delete(id);
    }


}
