package com.semicolon.africa.laundryluxe.services;

import com.semicolon.africa.laundryluxe.dto.request.SignupCustomerRequest;
import com.semicolon.africa.laundryluxe.dto.response.LoginCustomerRequest;
import com.semicolon.africa.laundryluxe.dto.response.LoginCustomerResponse;
import com.semicolon.africa.laundryluxe.dto.response.SignUpCustomerResponse;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Override
    public SignUpCustomerResponse signupCustomer(SignupCustomerRequest signupCustomerRequest) {
        return null;
    }

    @Override
    public LoginCustomerResponse loginCustomer(LoginCustomerRequest loginCustomerRequest) {
        return null;
    }
}
