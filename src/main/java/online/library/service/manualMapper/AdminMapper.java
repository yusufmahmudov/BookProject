package online.library.service.manualMapper;

import online.library.dto.AdminDto;
import online.library.entity.Admin;

public class AdminMapper {

    public static Admin toEntity(AdminDto adminDto){
        return Admin.builder()
                .id(adminDto.getId())
                .fullName(adminDto.getFullName())
                .email(adminDto.getEmail())
                .username(adminDto.getUsername())
                .password(adminDto.getPassword())
                .phoneNumber(adminDto.getPhoneNumber())
                .account(adminDto.getAccount())
                .build();
    }

    public static AdminDto toDto(Admin admin){
        return AdminDto.builder()
                .id(admin.getId())
                .fullName(admin.getFullName())
                .email(admin.getEmail())
                .username(admin.getUsername())
                .password(admin.getPassword())
                .phoneNumber(admin.getPhoneNumber())
                .account(admin.getAccount())
                .build();
    }
}
