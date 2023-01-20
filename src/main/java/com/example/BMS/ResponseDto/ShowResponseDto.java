package com.example.BMS.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowResponseDto {

    private String movieName;

    private String theatreName;

    private String theatreAddress;

    private LocalDate showDate;

    private LocalTime showTime;

}
