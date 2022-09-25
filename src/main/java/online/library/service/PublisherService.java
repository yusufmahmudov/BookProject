package online.library.service;

import online.library.dto.OrderDto;
import online.library.dto.PublisherDto;
import online.library.dto.ResponseDto;
import online.library.entity.Publisher;

import java.util.List;

public interface PublisherService {
    ResponseDto<List<PublisherDto>> getAllPublisher();
    ResponseDto<PublisherDto> getWithId(Integer id);
    ResponseDto addPublisher(PublisherDto publisherDto);
    ResponseDto updatePublisher(PublisherDto publisherDto);
    ResponseDto deletePublisher(Integer id);
}
