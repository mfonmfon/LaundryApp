package com.semicolon.africa.laundryluxe.services;

import com.semicolon.africa.laundryluxe.dto.request.LaundererSendRequest;
import com.semicolon.africa.laundryluxe.dto.request.LoginLaundererRequest;
import com.semicolon.africa.laundryluxe.dto.request.SignUpLaundererRequest;
import com.semicolon.africa.laundryluxe.dto.response.LaundererSendResponse;
import com.semicolon.africa.laundryluxe.dto.response.LoginLaundererResponse;
import com.semicolon.africa.laundryluxe.dto.response.SignUpCustomerResponse;

public interface LaundererService {
    SignUpCustomerResponse signUp(SignUpLaundererRequest request);
    LoginLaundererResponse loginLaunderer(LoginLaundererRequest request);
    LaundererSendResponse laundererSendPackage(LaundererSendRequest request);
}
