package com.farhad.example.realworld_demo.application.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.realworld_demo.domain.user.ProfileService;
import com.farhad.example.realworld_demo.domain.user.UserName;

import lombok.RequiredArgsConstructor;


@RequestMapping("/profiles")
@RestController
@RequiredArgsConstructor
public class ProfileRestController {

    private final ProfileService profileService;

    @GetMapping("/{username}")
    public ProfileModel getProfileByUsername(@PathVariable UserName userName) {
        return null;
    }
    
}
