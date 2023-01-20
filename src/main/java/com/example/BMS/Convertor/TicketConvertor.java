package com.example.BMS.Convertor;

import com.example.BMS.Model.TicketEntity;
import com.example.BMS.Model.UserEntity;
import com.example.BMS.ResponseDto.TicketResponseDto;

import java.util.ArrayList;
import java.util.List;

public class TicketConvertor {

    public static List<TicketResponseDto> convertEntityToDto(UserEntity user){
        List<TicketEntity> ticketList = user.getTickets();
        List<TicketResponseDto> dtoList = new ArrayList<>();

        for(TicketEntity ticket: ticketList){
            TicketResponseDto ticketResponseDto = TicketResponseDto.builder().userName(ticket.getUser().getName()).
                                                    allotedSeats(ticket.getAllotedSeats()).amount(ticket.getAmount()).
                                                        bookedAt(ticket.getBookedAt()).
                                                            show(ShowConvertor.convertEntityToDto(ticket.getShow())).build();

            dtoList.add(ticketResponseDto);
        }

        return dtoList;
    }
}
