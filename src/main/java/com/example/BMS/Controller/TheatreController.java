package com.example.BMS.Controller;

import com.example.BMS.RequestDto.TheatreRequestDto;
import com.example.BMS.Model.TheatreEntity;
import com.example.BMS.ResponseDto.TheatreResponseDto;
import com.example.BMS.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    TheatreService theatreService;

    @PostMapping("/create")
    public ResponseEntity<String> createTheatre(@RequestBody() TheatreRequestDto theatreRequestDto) throws Exception {

        String response = theatreService.createTheatre(theatreRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/get_by_id/{id}")
    public ResponseEntity<TheatreResponseDto> getById(@PathVariable int id){
        TheatreResponseDto theatre = theatreService.getById(id);
        return new ResponseEntity<>(theatre, HttpStatus.FOUND);
    }

    @GetMapping("/get_by_city/{cityName}")
    public ResponseEntity<List<TheatreResponseDto>> getByCity(@PathVariable String cityName){
        List<TheatreResponseDto> theatre = theatreService.getByCity(cityName);
        return new ResponseEntity<>(theatre, HttpStatus.FOUND);
    }

    @GetMapping("get_all")
    public ResponseEntity<List<TheatreResponseDto>> getAll(){
        List<TheatreResponseDto> theatres = theatreService.getAll();

        return new ResponseEntity<>(theatres, HttpStatus.FOUND);
    }
}