package com.semicolon.africa.laundryluxe.services;

import com.semicolon.africa.laundryluxe.dto.response.SignUpCustomerResponse;
import com.semicolon.africa.laundryluxe.dto.response.SignupCustomerRequest;

public interface CustomerService {

    SignUpCustomerResponse signupCustomer(SignupCustomerRequest signupCustomerRequest);
}
