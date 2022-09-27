package online.library.service.impl;

import lombok.RequiredArgsConstructor;
import online.library.dto.AuthorDto;
import online.library.dto.EBookDto;
import online.library.dto.ResponseDto;
import online.library.entity.Author;
import online.library.entity.EBook;
import online.library.repository.EBookRepository;
import online.library.service.EBookService;
import online.library.service.manualMapper.AuthorMapper;
import online.library.service.manualMapper.EBookMapper;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EBookSimple implements EBookService {

    private final EBookRepository eBookRepository;

    @Override
    public ResponseDto<List<EBookDto>> getAllEBook() {
        try {
            List<EBookDto> books = eBookRepository.findAll().stream().map(EBookMapper::toDto).toList();

            return ResponseDto.<List<EBookDto>>builder()
                    .code(0)
                    .success(true)
                    .message("OK")
                    .data(books)
                    .build();
        } catch (Exception i){
            i.printStackTrace();
            return ResponseDto.<List<EBookDto>>builder()
                    .code(-1)
                    .success(false)
                    .message("NO")
                    .build();
        }
    }

    @Override
    public ResponseDto<EBookDto> getWithId(Integer id) {
        Optional<EBook> eBook = eBookRepository.findById(id);

        if(eBook.isPresent()){
            EBookDto eBookDto = EBookMapper.toDto(eBook.get());
            return ResponseDto.<EBookDto>builder()
                    .code(0)
                    .success(true)
                    .message("OK")
                    .data(eBookDto)
                    .build();
        }
        return ResponseDto.<EBookDto>builder()
                .code(-1)
                .success(false)
                .message("NO")
                .build();
    }

    @Override
    public ResponseDto addEBook(EBookDto eBookDto) {
        try {
            eBookRepository.save(EBookMapper.toEntity(eBookDto));
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
    public ResponseDto updateEBook(EBookDto eBookDto) {
        try {
            eBookRepository.save(EBookMapper.toEntity(eBookDto));
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
    public ResponseDto deleteEBook(Integer id) {
        try {
            eBookRepository.deleteById(id);
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
                    .message("Was not deleted")
                    .build();
        }
    }

    @Override
    public ResponseEntity<Resource> download(Integer id)  {
        Optional<EBook> optionalEBook = eBookRepository.findById(id);
        EBookDto eBookDto = new EBookDto();
        if(optionalEBook.isPresent()){
            eBookDto = EBookMapper.toDto(optionalEBook.get());
        }

        File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("pdfDATA/" + eBookDto.getPath() + ".pdf")).getPath());
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=img.jpg");
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");

        InputStreamResource resource = new InputStreamResource(fileInputStream);

        return ResponseEntity.ok()
                .headers(header)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
