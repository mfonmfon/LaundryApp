package com.semicolon.africa.laundryluxe.services;

import com.semicolon.africa.laundryluxe.dto.request.LoginRequest;
import com.semicolon.africa.laundryluxe.dto.request.SignUpRiderRequest;
import com.semicolon.africa.laundryluxe.dto.response.LoginRiderResponse;
import com.semicolon.africa.laundryluxe.dto.response.SignUpCustomerResponse;
import com.semicolon.africa.laundryluxe.dto.response.SignUpRiderResponse;

public interface RiderService {

    SignUpRiderResponse signUpRider(SignUpRiderRequest request);

    LoginRiderResponse login(LoginRequest request);

}
