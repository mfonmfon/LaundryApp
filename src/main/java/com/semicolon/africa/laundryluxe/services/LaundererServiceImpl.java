package com.semicolon.africa.laundryluxe.services;

import com.semicolon.africa.laundryluxe.data.model.Launderer;
import com.semicolon.africa.laundryluxe.data.repository.LaundererRepository;
import com.semicolon.africa.laundryluxe.dto.request.SignUpLaundererRequest;
import com.semicolon.africa.laundryluxe.dto.response.SignUpCustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaundererServiceImpl implements LaundererService{

    @Autowired
    LaundererRepository laundererRepository;

    public SignUpCustomerResponse signUp(SignUpLaundererRequest request) {
        SignUpCustomerResponse response = new SignUpCustomerResponse();
        if(laundererRepository != null){
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
