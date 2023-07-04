package com.farhad.example.templatebasedemail.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.farhad.example.templatebasedemail.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BootstrapData implements ApplicationListener<ContextRefreshedEvent> {

    private final UserRepository userRepository;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // save data
    }
    
}
