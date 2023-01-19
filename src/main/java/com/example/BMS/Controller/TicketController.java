package com.example.BMS.Controller;

import com.example.BMS.Dto.BookTicketRequestDto;
import com.example.BMS.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody BookTicketRequestDto bookTicketRequestDto) {
        try {
            String respnse = ticketService.create(bookTicketRequestDto);

            return new ResponseEntity<>(respnse, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>("Requested Seats not available", HttpStatus.BAD_REQUEST);
        }
    }
}
