package com.example.BMS.Dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserRequestDto {

    private String name;

    @Column(nullable = false, unique = true)
    private String mobile;
}