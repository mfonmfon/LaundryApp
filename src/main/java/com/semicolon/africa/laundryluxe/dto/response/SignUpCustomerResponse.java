package com.semicolon.africa.laundryluxe.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpCustomerResponse {
    private Long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String confirmPassword;
    private String message;
}
