package online.bookStore.service.mapper;

import online.bookStore.dto.RegionDto;
import online.bookStore.entity.Region;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegionMapper {
    Region toEntity(RegionDto regionDto);
    RegionDto toDto(Region region);
}
