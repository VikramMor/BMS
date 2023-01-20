package com.example.BMS.Convertor;

import com.example.BMS.RequestDto.UserRequestDto;
import com.example.BMS.Model.UserEntity;
import com.example.BMS.ResponseDto.UserResponseDto;
import org.apache.catalina.User;

public class UserConvertor {

    public static UserEntity convertDtoToEntity(UserRequestDto userRequestDto){

        UserEntity user = UserEntity.builder().
                name(userRequestDto.getName()).
                mobile(userRequestDto.getMobile()).build();

        return user;
    }

    public static UserResponseDto convertEntityToDto(UserEntity user){

        UserResponseDto userResponseDto = UserResponseDto.builder().mobile(user.getMobile()).
                                                tickets(TicketConvertor.convertEntityToDto(user)).build();

        return userResponseDto;
    }
}