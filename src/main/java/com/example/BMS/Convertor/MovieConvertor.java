package com.example.BMS.Convertor;

import com.example.BMS.Dto.MovieRequestDto;
import com.example.BMS.Model.MovieEntity;

public class MovieConvertor {

    public static MovieEntity convertDtoToEntity(MovieRequestDto movieRequestDto){
        MovieEntity movieEntity = MovieEntity.builder().name(movieRequestDto.getName()).
                durationInMinutes(movieRequestDto.getDurationInMinutes()).build();

        return movieEntity;
    }
}