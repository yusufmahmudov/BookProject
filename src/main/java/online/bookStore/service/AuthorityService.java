package online.bookStore.service;
import online.bookStore.dto.AuthorityDto;
import online.bookStore.dto.ResponseDto;
import java.util.List;

public interface AuthorityService {
    ResponseDto<List<AuthorityDto>> getAllAuthority();
    ResponseDto<AuthorityDto> getById(Integer id);
    ResponseDto addAuthority(AuthorityDto authorityDto);
    ResponseDto updateAuthority(AuthorityDto authorityDto);
    ResponseDto delete(Integer id);
}
