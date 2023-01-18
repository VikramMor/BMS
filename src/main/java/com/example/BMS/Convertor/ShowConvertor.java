package com.example.BMS.Convertor;

import com.example.BMS.Dto.ShowRequestDto;
import com.example.BMS.Model.ShowEntity;

public class ShowConvertor {

    public static ShowEntity convertDtoToEntity(ShowRequestDto showRequestDto){
        ShowEntity show = ShowEntity.builder().showDate(showRequestDto.getShowDate()).
                                showTime(showRequestDto.getShowTime()).
                                    multiplier(showRequestDto.getMultiplier()).build();

        return show;
    }
}
