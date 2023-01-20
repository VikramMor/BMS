package com.example.BMS.ResponseDto;

import com.example.BMS.Enum.SeatType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

public class ShowSeatResponseDto {

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private boolean booked;
}
