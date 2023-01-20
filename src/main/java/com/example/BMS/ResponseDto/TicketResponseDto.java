package com.example.BMS.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketResponseDto {

    private String userName;

    private String allotedSeats;

    private int amount;

    private ShowResponseDto show;

    private Date bookedAt;

}
