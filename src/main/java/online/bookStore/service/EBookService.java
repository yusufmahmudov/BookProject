package online.bookStore.service;

import online.bookStore.dto.EBookDto;
import online.bookStore.dto.ResponseDto;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EBookService {
    ResponseDto<List<EBookDto>> getAllEBook();
    ResponseDto<EBookDto> getWithId(Integer id);
    ResponseDto addEBook(EBookDto eBookDto);
    ResponseDto updateEBook(EBookDto eBookDto);
    ResponseDto deleteEBook(Integer id);

    ResponseEntity<Resource> download(Integer id) ;

}
