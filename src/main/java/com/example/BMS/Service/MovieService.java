package com.example.BMS.Service;

import com.example.BMS.Convertor.MovieConvertor;
import com.example.BMS.RequestDto.MovieRequestDto;
import com.example.BMS.Model.MovieEntity;
import com.example.BMS.Repository.MovieRepo;
import com.example.BMS.ResponseDto.MovieResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepo movieRepo;

    public String createMovie(MovieRequestDto movieRequestDto) {
        try {
            MovieEntity movie = MovieConvertor.convertDtoToEntity(movieRequestDto);
            movieRepo.save(movie);
        }
        catch (Exception e){
            throw new RuntimeException("Not able to add requested movie!!");
        }
        return "Movie added Successfully!";
    }

    public MovieResponseDto getMovieByName(String name){
        try {
            MovieEntity movie = movieRepo.findByName(name);
            MovieResponseDto movieResponseDto = MovieConvertor.convertEntityToDto(movie);
            return movieResponseDto;
        }
        catch (Exception e){
            throw new RuntimeException("Requested Movie does not exist in Database!!");
        }
    }

    public List<MovieResponseDto> getAllMovies(){
        try {
            List<MovieEntity> movies = movieRepo.findAll();
            List<MovieResponseDto> dtoList = new ArrayList<>();

            for(MovieEntity movie : movies){
                MovieResponseDto movieResponseDto = MovieConvertor.convertEntityToDto(movie);
                dtoList.add(movieResponseDto);
            }
            return dtoList;
        }
        catch (Exception e){
            throw new RuntimeException("No Movies exist in Database!!");
        }
    }
}
