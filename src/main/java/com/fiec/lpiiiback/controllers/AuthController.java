package com.fiec.lpiiiback.controllers;

import com.fiec.lpiiiback.models.dto.AuthRequestDto;
import com.fiec.lpiiiback.models.dto.LoginResponseDto;
import com.fiec.lpiiiback.services.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    FirebaseService firebaseService;

    @PostMapping("/signUp")
    public void signUp(@RequestBody AuthRequestDto authRequestDto){
        firebaseService.signUp(authRequestDto);
    }

    @PostMapping("/signIn")
    public LoginResponseDto signIn(@RequestBody AuthRequestDto authRequestDto){
        String token = firebaseService.signIn(authRequestDto);
        return LoginResponseDto.builder()
                .token(token)
                .build();
    }
}
