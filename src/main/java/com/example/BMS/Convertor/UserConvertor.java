package com.example.BMS.Convertor;

import com.example.BMS.Dto.UserRequestDto;
import com.example.BMS.Model.UserEntity;

public class UserConvertor {

    public static UserEntity convertDtoToEntity(UserRequestDto userRequestDto){

        UserEntity user = UserEntity.builder().
                name(userRequestDto.getName()).
                mobile(userRequestDto.getMobile()).build();

        return user;
    }
}