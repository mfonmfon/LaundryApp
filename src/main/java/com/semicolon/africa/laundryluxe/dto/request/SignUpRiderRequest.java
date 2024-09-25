package com.semicolon.africa.laundryluxe.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignUpRiderRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String password;
    private String confirmPassword;

}

