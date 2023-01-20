package com.example.BMS.RequestDto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowRequestDto {

    private LocalDate showDate;

    private LocalTime showTime;

    private double multiplier;

    private String movieName;

    private int theatreId;
}
