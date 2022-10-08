package online.bookStore.controller;

import lombok.RequiredArgsConstructor;
import online.bookStore.dto.RegionDto;
import online.bookStore.dto.ResponseDto;
import online.bookStore.service.impl.RegionServiceImpl;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/region")
@RequiredArgsConstructor
public class RegionController {

    private final RegionServiceImpl regionService;

    @GetMapping("all")
    public ResponseDto<List<RegionDto>> getAllRegions() {
        return regionService.getAllRegions();
    }

    @GetMapping("/{id}")
    public ResponseDto<RegionDto> getById(@PathVariable Integer id) {
        return regionService.getById(id);
    }

    @PostMapping("/add")
    public ResponseDto add(@RequestBody RegionDto dto) {
        return regionService.add(dto);
    }

    @PutMapping
    public ResponseDto update(@RequestBody RegionDto dto) {
        return regionService.update(dto);
    }

    @DeleteMapping
    public ResponseDto delete(@RequestParam Integer id) {
        return regionService.delete(id);
    }

}
