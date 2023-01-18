package com.example.BMS.Convertor;

import com.example.BMS.Dto.TheatreRequestDto;
import com.example.BMS.Model.TheatreEntity;

public class TheatreConvertor {

    public static TheatreEntity convertDtoToEntity(TheatreRequestDto theatreRequestDto){
        TheatreEntity theatreEntity = TheatreEntity.builder().name(theatreRequestDto.getName()).
                city(theatreRequestDto.getCity()).
                address(theatreRequestDto.getAddress()).build();

        return theatreEntity;
    }
}