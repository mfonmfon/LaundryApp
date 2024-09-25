package com.semicolon.africa.laundryluxe.services;

import com.semicolon.africa.laundryluxe.data.model.Launderer;
import com.semicolon.africa.laundryluxe.data.repository.LaundererRepository;
import com.semicolon.africa.laundryluxe.dto.request.LaundererSendRequest;
import com.semicolon.africa.laundryluxe.dto.request.LoginLaundererRequest;
import com.semicolon.africa.laundryluxe.dto.request.SignUpLaundererRequest;
import com.semicolon.africa.laundryluxe.dto.response.LaundererSendResponse;
import com.semicolon.africa.laundryluxe.dto.response.LoginLaundererResponse;
import com.semicolon.africa.laundryluxe.dto.response.SignUpCustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaundererServiceImpl implements LaundererService{

    @Autowired
    LaundererRepository laundererRepository;

    public SignUpCustomerResponse signUp(SignUpLaundererRequest request) {
        SignUpCustomerResponse response = new SignUpCustomerResponse();
        if(laundererRepository.findByEmail(request.getEmail()) == null){
            Launderer launderer = new Launderer();
            launderer.setFirstName(validateFirstName(request.getFirstName()).toLowerCase());
            launderer.setLastName(validateLastName(request.getLastName()).toLowerCase());
            launderer.setPhoneNumber(validatePhoneNumber(request.getPhoneNumber()).toLowerCase());
            launderer.setEmail(validateEmail(request.getEmail()).toLowerCase());
            launderer.setPassword(validatePassword(request.getPassword()).toLowerCase());
            launderer.setConfirmPassword(validatePassword(request.getConfirmPassword()).toLowerCase());
            laundererRepository.save(launderer);
        }
        else{
            throw new IllegalArgumentException("User already exists");
        }
        response.setMessage("Successfully signed up");
        return response;
    }

    public LoginLaundererResponse loginLaunderer(LoginLaundererRequest request) {
        LoginLaundererResponse response = new LoginLaundererResponse();
        Launderer launderer =  laundererRepository.findByEmailAndPassword(validateEmail(request.getEmail()).toLowerCase(),validatePassword(request.getPassword()).toLowerCase());
        if(launderer != null){
            response.setLoggedIn(true);
            launderer.setLoggedIn(true);
        }
        else{
            response.setLoggedIn(false);
            launderer.setLoggedIn(false);
        }
        return response;
    }

    public LaundererSendResponse laundererSendPackage(LaundererSendRequest request){
        return null;
    }












    private String validateFirstName(String firstName) {
        if (firstName.contains(" ")) {
            throw new IllegalArgumentException("Invalid first name");
        }
        return firstName;
    }

    private String validateLastName(String lastName) {
        if (lastName.contains(" ")) {
            throw new IllegalArgumentException("Invalid last name");
        }
        return lastName;
    }

    private String validateEmail(String email) {
        if (email.contains(" ") || !email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Invalid email");
        }
        return email;
    }

    private String validatePhoneNumber(String phoneNumber) {
        long number = Long.parseLong(phoneNumber);
        if (phoneNumber.contains(" ") || phoneNumber.length() != 11) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        return String.valueOf(number);
    }

    private String validatePassword(String password) {
        if (password.contains(" ")) {
            throw new IllegalArgumentException("Invalid password");
        }
        return password;
    }





}
