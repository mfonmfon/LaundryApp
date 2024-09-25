package com.semicolon.africa.laundryluxe.dto.request;

import lombok.Getter;

import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SendCustomerOrderRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String homeAddress;
    private String specialInstructions;
    private LocalDateTime createdAt;
}
