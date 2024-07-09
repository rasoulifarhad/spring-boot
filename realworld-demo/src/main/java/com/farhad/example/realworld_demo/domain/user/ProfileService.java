package com.farhad.example.realworld_demo.domain.user;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final UserFindService userFindService;
}
