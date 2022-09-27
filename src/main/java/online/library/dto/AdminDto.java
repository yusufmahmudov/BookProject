package online.library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {
    private Integer id;

    private String fullName;

    private String email;

    private String phoneNumber;

    private String username;
    private String password;

    private Double account;
}
