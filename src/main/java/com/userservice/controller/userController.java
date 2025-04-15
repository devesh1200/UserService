package com.userservice.controller;


import com.userservice.entities.UserInfoDto;
import com.userservice.repo.UserRepository;
import com.userservice.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")

public class userController {


    @Autowired
    UserRepository userRepository;

    @Autowired
    UserSerivce userSerivce;

    @PostMapping("/createUpdateUser")
    public ResponseEntity<UserInfoDto> createUser(@RequestBody UserInfoDto userInfoDto) {
        try {
            UserInfoDto user = userSerivce.createAndUpdateUser(userInfoDto);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/user/v1/getUser")
    public ResponseEntity<UserInfoDto> getUser(@RequestBody UserInfoDto userInfoDto) {
        try {
            UserInfoDto user = userSerivce.getUser(userInfoDto);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/health")
    public ResponseEntity<Boolean> checkHealth() {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
