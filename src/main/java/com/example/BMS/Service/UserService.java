package com.example.BMS.Service;

import com.example.BMS.Convertor.UserConvertor;
import com.example.BMS.Dto.UserRequestDto;
import com.example.BMS.Model.UserEntity;
import com.example.BMS.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<UserEntity> getUserByName(String name){
        try{
            return userRepo.findByName(name);
        }
        catch (Exception e){
            throw new RuntimeException("Problem fetching User by name!!");
        }
    }

    public List<UserEntity> getAllUsers(){
        try {
            return userRepo.findAll();
        }
        catch (Exception e){
            throw new RuntimeException("Problem fetching Users!!");
        }
    }

}