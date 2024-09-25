package com.semicolon.africa.laundryluxe.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginCustomerResponse {
    private String message;
    private boolean isLoggedIn;
}
