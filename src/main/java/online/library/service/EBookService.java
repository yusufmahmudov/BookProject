package online.library.service;

import online.library.dto.CardDto;
import online.library.dto.EBookDto;
import online.library.dto.ResponseDto;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import java.io.FileNotFoundException;
import java.util.List;

public interface EBookService {
    ResponseDto<List<EBookDto>> getAllEBook();
    ResponseDto<EBookDto> getWithId(Integer id);
    ResponseDto addEBook(EBookDto eBookDto);
    ResponseDto updateEBook(EBookDto eBookDto);
    ResponseDto deleteEBook(Integer id);

    ResponseEntity<Resource> download(Integer id) ;

}
