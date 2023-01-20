package com.example.BMS.RequestDto;

import lombok.Data;

import java.util.List;

@Data
public class BookTicketRequestDto {

    private List<String> requestedSeats;

    private int showId;

    private int userId;
}
