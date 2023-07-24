package com.farhad.example.valueobjectsdemo.domain.value;

import com.farhad.example.valueobjectsdemo.domain.User;
import com.farhad.example.valueobjectsdemo.domain.User.Name;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    
    private User.ID id;
    private PhoneNumber phoneNumber;
    private Passport passport;
    private Name name;


}
