package com.example.BMS.Convertor;

import com.example.BMS.Model.MovieEntity;
import com.example.BMS.RequestDto.ShowRequestDto;
import com.example.BMS.Model.ShowEntity;
import com.example.BMS.ResponseDto.ShowResponseDto;

import java.util.ArrayList;
import java.util.List;

public class ShowConvertor {

    public static ShowEntity convertDtoToEntity(ShowRequestDto showRequestDto){
        ShowEntity show = ShowEntity.builder().showDate(showRequestDto.getShowDate()).
                                showTime(showRequestDto.getShowTime()).
                                    multiplier(showRequestDto.getMultiplier()).build();

        return show;
    }
    public static List<ShowResponseDto> convertEntityToDto(MovieEntity movie){
        List<ShowEntity> showList = movie.getShowEntityList();
        List<ShowResponseDto> dtoList = new ArrayList<>();
        for(ShowEntity show : showList) {
            ShowResponseDto showResponseDto = ShowResponseDto.builder().showTime(show.getShowTime()).
                                                    showDate(show.getShowDate()).movieName(movie.getName()).
                                                        theatreName(show.getTheatreEntity().getName()).
                                                            theatreAddress(show.getTheatreEntity().getAddress()).build();
            dtoList.add(showResponseDto);
        }
        return dtoList;
    }

    public static ShowResponseDto convertEntityToDto(ShowEntity show){
        ShowResponseDto showResponseDto = ShowResponseDto.builder().showDate(show.getShowDate()).
                                            showTime(show.getShowTime()).movieName(show.getMovieEntity().getName()).
                                                theatreName(show.getTheatreEntity().getName()).
                                                    theatreAddress(show.getTheatreEntity().getAddress()).build();

        return showResponseDto;
    }
}
