package online.library.controller;

import lombok.RequiredArgsConstructor;
import online.library.dto.AdminDto;
import online.library.dto.AuthorDto;
import online.library.dto.ResponseDto;
import online.library.service.AdminService;
import online.library.service.impl.AdminSimple;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminSimple adminSimple;

    @GetMapping
    public ResponseDto<List<AdminDto>> getAllAdmin(){
        return adminSimple.getAllAdmin();
    }

    @GetMapping("/{id}")
    public ResponseDto<AdminDto> getById(@PathVariable Integer id){
        return adminSimple.getWithId(id);
    }

    @PostMapping
    public ResponseDto addAdmin(@RequestBody AdminDto adminDto){
        return adminSimple.addAdmin(adminDto);
    }

    @PutMapping
    public ResponseDto updateAdmin(@RequestBody AdminDto adminDto){
        return adminSimple.updateAdmin(adminDto);
    }

    @DeleteMapping
    public ResponseDto deleteAdmin(@RequestParam Integer id){
        return adminSimple.deleteWithId(id);
    }


}
