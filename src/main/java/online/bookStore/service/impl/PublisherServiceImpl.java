package online.bookStore.service.impl;

import lombok.RequiredArgsConstructor;
import online.bookStore.dto.PublisherDto;
import online.bookStore.dto.ResponseDto;
import online.bookStore.entity.Publisher;
import online.bookStore.repository.PublisherRepository;
import online.bookStore.service.PublisherService;
import online.bookStore.service.mapper.PublisherMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    @Override
    public ResponseDto<List<PublisherDto>> getAllPublisher() {
        try {
            List<PublisherDto> publishers = publisherRepository.findAll().stream().map(PublisherMapper::toDto).toList();

            return ResponseDto.<List<PublisherDto>>builder()
                    .code(0)
                    .success(true)
                    .message("OK")
                    .data(publishers)
                    .build();
        } catch (Exception i){
            i.printStackTrace();
            return ResponseDto.<List<PublisherDto>>builder()
                    .code(-1)
                    .success(false)
                    .message("NO")
                    .build();
        }
    }

    @Override
    public ResponseDto<PublisherDto> getWithId(Integer id) {
        Optional<Publisher> publisher = publisherRepository.findById(id);

        if(publisher.isPresent()){
            PublisherDto publisherDto = PublisherMapper.toDto(publisher.get());
            return ResponseDto.<PublisherDto>builder()
                    .code(0)
                    .success(true)
                    .message("OK")
                    .data(publisherDto)
                    .build();
        }
        return ResponseDto.<PublisherDto>builder()
                .code(-1)
                .success(false)
                .message("NO")
                .build();
    }

    @Override
    public ResponseDto addPublisher(PublisherDto publisherDto) {
        try {
            publisherRepository.save(PublisherMapper.toEntity(publisherDto));
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
    public ResponseDto updatePublisher(PublisherDto publisherDto) {
        try {
            publisherRepository.save(PublisherMapper.toEntity(publisherDto));
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
    public ResponseDto deletePublisher(Integer id) {
        try {
            publisherRepository.deleteById(id);
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
}
