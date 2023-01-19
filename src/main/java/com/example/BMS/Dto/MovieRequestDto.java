package com.example.BMS.Dto;

import javax.persistence.*;
import lombok.Data;

@Data
public class MovieRequestDto {

    @Column(nullable = false, unique = true)
    private String name;

    private int durationInMinutes;
}