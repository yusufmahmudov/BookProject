package online.library.service;

import online.library.dto.AdminDto;
import online.library.dto.AuthorDto;
import online.library.dto.ResponseDto;

import java.util.List;

public interface AdminService {
    ResponseDto<List<AdminDto>> getAllAdmin();
    ResponseDto<AdminDto> getWithId(Integer id);
    ResponseDto addAdmin(AdminDto adminDto);
    ResponseDto updateAdmin(AdminDto adminDto);
    ResponseDto deleteWithId(Integer id);

}
