package com.microservices.user.controllers;

import com.microservices.user.dtos.UserRecordDto;
import com.microservices.user.models.UserModel;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/users")
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserRecordDto useRecordDto){
       var userModel = new UserModel();
        BeanUtils.copyProperties(useRecordDto, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userModel);
    }
}
