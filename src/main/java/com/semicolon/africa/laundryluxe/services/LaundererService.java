package com.semicolon.africa.laundryluxe.services;

import com.semicolon.africa.laundryluxe.dto.request.SignUpLaundererRequest;
import com.semicolon.africa.laundryluxe.dto.response.SignUpCustomerResponse;

public interface LaundererService {
    SignUpCustomerResponse signUp(SignUpLaundererRequest request);
}
