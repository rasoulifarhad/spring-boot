package com.farhad.example.dddbank.domain.shared.exceptions;

public class WithoutRightException extends BusinessException {
    // Client with username {0} ist neither owner nor manager of the account with number {1}.
    // String username;
    // AccountNo accountNo;
}
