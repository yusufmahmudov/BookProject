package online.bookStore.service;

import online.bookStore.dto.PublisherDto;
import online.bookStore.dto.ResponseDto;

import java.util.List;

public interface PublisherService {
    ResponseDto<List<PublisherDto>> getAllPublisher();
    ResponseDto<PublisherDto> getWithId(Integer id);
    ResponseDto addPublisher(PublisherDto publisherDto);
    ResponseDto updatePublisher(PublisherDto publisherDto);
    ResponseDto deletePublisher(Integer id);
}
