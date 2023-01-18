package com.example.BMS.Controller;

import com.example.BMS.Dto.TheatreRequestDto;
import com.example.BMS.Model.TheatreEntity;
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
    public ResponseEntity<TheatreEntity> getById(@PathVariable int id){
        TheatreEntity theatre = theatreService.getById(id);
        return new ResponseEntity<>(theatre, HttpStatus.FOUND);
    }

    @GetMapping("get_all")
    public ResponseEntity<List<TheatreEntity>> getAll(){
        List<TheatreEntity> theatres = theatreService.getAll();

        return new ResponseEntity<>(theatres, HttpStatus.FOUND);
    }
}