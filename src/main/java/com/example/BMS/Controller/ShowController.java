package com.example.BMS.Controller;

import com.example.BMS.Dto.ShowRequestDto;
import com.example.BMS.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody()ShowRequestDto showRequestDto){
        String response = showService.createShow(showRequestDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
