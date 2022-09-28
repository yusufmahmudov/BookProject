package online.bookStore.service.mapper;

import online.bookStore.dto.PublisherDto;
import online.bookStore.entity.Publisher;

public class PublisherMapper {
    public static Publisher toEntity(PublisherDto publisherDto){
        return Publisher.builder()
                .id(publisherDto.getId())
                .name(publisherDto.getName())
                .location(publisherDto.getLocation())
                .build();
    }

    public static PublisherDto toDto(Publisher publisher){
        return PublisherDto.builder()
                .id(publisher.getId())
                .name(publisher.getName())
                .location(publisher.getLocation())
                .build();
    }
}
