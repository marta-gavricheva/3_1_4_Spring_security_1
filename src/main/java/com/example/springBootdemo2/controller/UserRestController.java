package com.example.springBootdemo2.controller;

import com.example.springBootdemo2.model.User;
import com.example.springBootdemo2.service.UserServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user_api")
public class UserRestController {

    @GetMapping("")
    public User getUs(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return user;
    }


}

