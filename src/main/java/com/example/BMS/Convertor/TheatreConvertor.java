package com.example.BMS.Convertor;

import com.example.BMS.RequestDto.TheatreRequestDto;
import com.example.BMS.Model.TheatreEntity;
import com.example.BMS.ResponseDto.TheatreResponseDto;

public class TheatreConvertor {

    public static TheatreEntity convertDtoToEntity(TheatreRequestDto theatreRequestDto){
        TheatreEntity theatreEntity = TheatreEntity.builder().name(theatreRequestDto.getName()).
                city(theatreRequestDto.getCity()).
                address(theatreRequestDto.getAddress()).build();

        return theatreEntity;
    }

    public static TheatreResponseDto convertEntityToDto(TheatreEntity theatre){
        TheatreResponseDto theatreResponseDto= TheatreResponseDto.builder().name(theatre.getName()).
                                                    city(theatre.getCity()).address(theatre.getAddress()).
                                                        seatCount(theatre.getTheatreSeatEntityList().size()).build();

        return theatreResponseDto;
    }
}