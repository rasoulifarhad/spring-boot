package com.farhad.example.dddbank.domain.shared.exceptions;

public class DuplicateUsernameException  extends BusinessException{
    // The requested username "{0}" is already in use with ID {1}, but usernames must be unique in the system.
    // String userName;
    // LOng clientId;
}
