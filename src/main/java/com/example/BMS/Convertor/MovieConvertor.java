package com.example.BMS.Convertor;

import com.example.BMS.RequestDto.MovieRequestDto;
import com.example.BMS.Model.MovieEntity;
import com.example.BMS.ResponseDto.MovieResponseDto;

public class MovieConvertor {

    public static MovieEntity convertDtoToEntity(MovieRequestDto movieRequestDto){
        MovieEntity movieEntity = MovieEntity.builder().name(movieRequestDto.getName()).
                durationInMinutes(movieRequestDto.getDurationInMinutes()).build();

        return movieEntity;
    }

    public static MovieResponseDto convertEntityToDto(MovieEntity movie){
        MovieResponseDto movieResponseDto = MovieResponseDto.builder().name(movie.getName()).
                                                duration(movie.getDurationInMinutes()).
                                                    releaseDate(movie.getReleaseDate()).
                                                        showList(ShowConvertor.convertEntityToDto(movie)).build();

        return movieResponseDto;
    }
}