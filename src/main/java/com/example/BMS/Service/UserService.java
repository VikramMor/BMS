package com.example.BMS.Service;

import com.example.BMS.Convertor.UserConvertor;
import com.example.BMS.RequestDto.UserRequestDto;
import com.example.BMS.Model.UserEntity;
import com.example.BMS.Repository.UserRepo;
import com.example.BMS.ResponseDto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public String createUser(UserRequestDto userRequestDto) {

        try {
            UserEntity user = UserConvertor.convertDtoToEntity(userRequestDto);
            userRepo.save(user);
            return "User Added Successfully!";
        }
        catch (Exception e){
            throw new RuntimeException("Not able to add requested user!!");
        }
    }

    public List<UserResponseDto> getUserByName(String name){
        try{
            List<UserEntity> users = userRepo.findByName(name);
            List<UserResponseDto> dtoList = new ArrayList<>();

            for(UserEntity user : users){
                UserResponseDto userResponseDto = UserConvertor.convertEntityToDto(user);
                dtoList.add(userResponseDto);
            }
            return dtoList;
        }
        catch (Exception e){
            throw new RuntimeException("Problem fetching User by name!!");
        }
    }

    public UserResponseDto getUserByMobile(String mobile){
        UserEntity user = userRepo.findByMobile(mobile);
        UserResponseDto userResponseDto = UserConvertor.convertEntityToDto(user);
        return userResponseDto;
    }

    public List<UserResponseDto> getAllUsers(){
        try {
            List<UserEntity> users = userRepo.findAll();
            List<UserResponseDto> dtoList = new ArrayList<>();

            for(UserEntity user : users){
                UserResponseDto userResponseDto = UserConvertor.convertEntityToDto(user);
                dtoList.add(userResponseDto);
            }
            return dtoList;
        }
        catch (Exception e){
            throw new RuntimeException("Problem fetching Users!!");
        }
    }

}