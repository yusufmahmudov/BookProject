package online.library.service.impl;

import lombok.RequiredArgsConstructor;
import online.library.dto.AdminDto;
import online.library.dto.AuthorDto;
import online.library.dto.ResponseDto;
import online.library.entity.Admin;
import online.library.entity.Author;
import online.library.repository.AdminRepository;
import online.library.service.AdminService;
import online.library.service.manualMapper.AdminMapper;
import online.library.service.manualMapper.AuthorMapper;
import org.springframework.stereotype.Service;

import javax.persistence.SecondaryTable;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminSimple implements AdminService {

    private final AdminRepository adminRepository;

    @Override
    public ResponseDto<List<AdminDto>> getAllAdmin() {
        try {
            List<AdminDto> adminDtos = adminRepository.findAll().stream().map(AdminMapper::toDto).toList();

            return ResponseDto.<List<AdminDto>>builder()
                    .code(0)
                    .success(true)
                    .message("OK")
                    .data(adminDtos)
                    .build();
        } catch (Exception i){
            i.printStackTrace();
            return ResponseDto.<List<AdminDto>>builder()
                    .code(-1)
                    .success(false)
                    .message("NO")
                    .build();
        }

    }

    @Override
    public ResponseDto<AdminDto> getWithId(Integer id) {
        Optional<Admin> admin = adminRepository.findById(id);

        if(admin.isPresent()){
            AdminDto adminDto = AdminMapper.toDto(admin.get());
            return ResponseDto.<AdminDto>builder()
                    .code(0)
                    .success(true)
                    .message("OK")
                    .data(adminDto)
                    .build();
        }
        return ResponseDto.<AdminDto>builder()
                .code(-1)
                .success(false)
                .message("NO")
                .build();

    }

    @Override
    public ResponseDto addAdmin(AdminDto adminDto) {
        try {
            adminRepository.save(AdminMapper.toEntity(adminDto));
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
    public ResponseDto updateAdmin(AdminDto adminDto) {
        try {
            adminRepository.save(AdminMapper.toEntity(adminDto));
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
    public ResponseDto deleteWithId(Integer id) {
        try {
            adminRepository.deleteById(id);
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
                    .message("NO")
                    .build();
        }
    }

}
