package online.bookStore.controller;

import lombok.RequiredArgsConstructor;
import online.bookStore.dto.AuthorityDto;
import online.bookStore.dto.ResponseDto;
import online.bookStore.service.impl.AuthorityServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authority")
public class AuthorityController {

    private final AuthorityServiceImpl authorityService;

    @GetMapping("/all")
    public ResponseDto<List<AuthorityDto>> getAllAuthority(){
        return authorityService.getAllAuthority();
    }

    @GetMapping("/{id}")
    public ResponseDto<AuthorityDto> getById(@PathVariable Integer id){
        return authorityService.getById(id);
    }

    @PostMapping("/add")
    public ResponseDto addAuthority(@RequestBody AuthorityDto authorityDto){
        return authorityService.addAuthority(authorityDto);
    }

    @PutMapping
    public ResponseDto updateAuthority(@RequestBody AuthorityDto authorityDto){
        return authorityService.updateAuthority(authorityDto);
    }

    @DeleteMapping
    public ResponseDto delete(@RequestParam Integer id){
        return authorityService.delete(id);
    }

}