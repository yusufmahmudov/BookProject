package online.bookStore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CardDto {
    private Integer id;
    private String name;
    private String cardNumber;
    private UserDto userDto;
    private Date valid_date;
    private Double account;
}
