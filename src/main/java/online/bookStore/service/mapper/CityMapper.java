package online.bookStore.service.mapper;

import online.bookStore.dto.CityDto;
import online.bookStore.entity.City;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper {
    City toEntity(CityDto cityDto);
    CityDto toDto(City city);
}
