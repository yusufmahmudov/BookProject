package online.bookStore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAddressDto {
    private Integer id;

    private UserDto user;

    private CityDto city;

    private RegionDto region;

    private String name_street;

    private Integer number_house;

    private Double distanceFromBookstore;
}
