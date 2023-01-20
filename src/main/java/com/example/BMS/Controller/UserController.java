package com.example.BMS.Controller;

import com.example.BMS.RequestDto.UserRequestDto;
import com.example.BMS.Model.UserEntity;
import com.example.BMS.ResponseDto.UserResponseDto;
import com.example.BMS.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody() UserRequestDto userRequestDto){
        String response = userService.createUser(userRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/get_by_name/{name}")
    public ResponseEntity<List<UserResponseDto>> getUserByName(@PathVariable String name){
        List<UserResponseDto> list = userService.getUserByName(name);
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }

    @GetMapping("get_by_mobile/{mobile}")
    public ResponseEntity<UserResponseDto> getUserByMobile(@PathVariable String mobile){
        UserResponseDto user = userService.getUserByMobile(mobile);
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @GetMapping("/get_all")
    public ResponseEntity<List<UserResponseDto>> getAllUsers(){
        List<UserResponseDto> list = userService.getAllUsers();
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }
}