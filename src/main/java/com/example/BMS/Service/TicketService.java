package com.example.BMS.Service;

import com.example.BMS.RequestDto.BookTicketRequestDto;
import com.example.BMS.Model.ShowEntity;
import com.example.BMS.Model.ShowSeatEntity;
import com.example.BMS.Model.TicketEntity;
import com.example.BMS.Model.UserEntity;
import com.example.BMS.Repository.ShowRepo;
import com.example.BMS.Repository.TicketRepo;
import com.example.BMS.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    ShowRepo showRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    TicketRepo ticketRepo;

    public String create(BookTicketRequestDto bookTicketRequestDto) throws Exception {

        List<String> requestedSeats = bookTicketRequestDto.getRequestedSeats();

        ShowEntity show = showRepo.findById(bookTicketRequestDto.getShowId()).get();

        UserEntity user = userRepo.findById(bookTicketRequestDto.getUserId()).get();

        List<ShowSeatEntity> showSeats = show.getShowSeatEntityList();

        List<ShowSeatEntity> bookedSeats = new ArrayList<>();

        // for checking whether all the requested seats are available or not
        for(ShowSeatEntity showSeat : showSeats){

            String seatNo = showSeat.getSeatNo();

            if(!showSeat.isBooked() && requestedSeats.contains(seatNo)){
                bookedSeats.add(showSeat);
            }
        }

        // all requested seats are not availabe
        if(bookedSeats.size() != requestedSeats.size()){
            throw new Exception("Requested Seats not available!!");
        }

        TicketEntity ticket = new TicketEntity();
        // calculate the amount for all the tickets booked

        double totalAmount = 0;
        int rate = 0;
        double multiplier = show.getMultiplier();
        String allotedSeats = "";

        for(ShowSeatEntity bookedSeat : bookedSeats){
            bookedSeat.setBooked(true);
            bookedSeat.setBookedAt(new Date());
            bookedSeat.setTicket(ticket);
            bookedSeat.setShow(show);

            String seatNo = bookedSeat.getSeatNo();
            allotedSeats = allotedSeats + seatNo +",";
            if(seatNo.charAt(1) == 'A'){
                rate = 100;
            }
            else {
                rate = 200;
            }
            totalAmount = totalAmount + multiplier*rate;
        }

        ticket.setBookedAt(new Date());
        ticket.setAmount((int)(totalAmount));
        ticket.setShow(show);
        ticket.setUser(user);
        ticket.setShowSeatEntityList(bookedSeats);
        ticket.setAllotedSeats(allotedSeats);

        ticketRepo.save(ticket);
        return "Ticket Successfully created!";
    }
}
