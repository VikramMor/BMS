package com.example.BMS.Service;

import com.example.BMS.Convertor.MovieConvertor;
import com.example.BMS.Dto.MovieRequestDto;
import com.example.BMS.Model.MovieEntity;
import com.example.BMS.Repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public MovieEntity getMovieByName(String name){
        try {
            MovieEntity movie = movieRepo.findByName(name);
            return movie;
        }
        catch (Exception e){
            throw new RuntimeException("Requested Movie does not exist in Database!!");
        }
    }

    public List<MovieEntity> getAllMovies(){
        try {
            List<MovieEntity> movies = movieRepo.findAll();
            return movies;
        }
        catch (Exception e){
            throw new RuntimeException("No Movies exist in Database!!");
        }
    }
}
