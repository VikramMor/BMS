package com.example.BMS.Controller;

import com.example.BMS.RequestDto.MovieRequestDto;
import com.example.BMS.Model.MovieEntity;
import com.example.BMS.ResponseDto.MovieResponseDto;
import com.example.BMS.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class
MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/create")
    public ResponseEntity<String> createMovie(@RequestBody() MovieRequestDto movieRequestDto) throws Exception {
        String response = movieService.createMovie(movieRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/get_by_name/{name}")
    public ResponseEntity<MovieResponseDto> getMovieByName(@PathVariable String name){
        MovieResponseDto movie = movieService.getMovieByName(name);
        return new ResponseEntity<>(movie, HttpStatus.FOUND);
    }

    @GetMapping("/get_all")
    public ResponseEntity<List<MovieResponseDto>> getAllMovies(){
        List<MovieResponseDto> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.FOUND);
    }
}
