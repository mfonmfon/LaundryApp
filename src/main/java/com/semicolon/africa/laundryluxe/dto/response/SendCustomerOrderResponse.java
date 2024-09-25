package com.semicolon.africa.laundryluxe.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SendCustomerOrderResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String homeAddress;
    private String specialInstructions;
    private LocalDateTime dateCreated;
    private String message;
}
