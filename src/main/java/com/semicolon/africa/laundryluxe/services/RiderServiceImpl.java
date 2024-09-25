package com.semicolon.africa.laundryluxe.services;

import com.semicolon.africa.laundryluxe.data.model.Rider;
import com.semicolon.africa.laundryluxe.data.repository.RiderRepository;
import com.semicolon.africa.laundryluxe.dto.request.LoginRequest;
import com.semicolon.africa.laundryluxe.dto.request.SignUpRiderRequest;
import com.semicolon.africa.laundryluxe.dto.response.LoginRiderResponse;
import com.semicolon.africa.laundryluxe.dto.response.SignUpRiderResponse;
import com.semicolon.africa.laundryluxe.exceptions.PasswordMismatchException;
import com.semicolon.africa.laundryluxe.exceptions.RiderAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiderServiceImpl implements RiderService {

    private final RiderRepository riderRepository;

    @Autowired
    public RiderServiceImpl(RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }

    @Override
    public SignUpRiderResponse signUpRider(SignUpRiderRequest request) {
        validate(request);
        Rider rider = new Rider();
        rider.setFirstName(request.getFirstName());
        rider.setLastName(request.getLastName());
        rider.setEmail(request.getEmail());
        rider.setPhoneNumber(request.getPhoneNumber());
        rider.setPassword(request.getPassword());
        rider.setConfirmPassword(request.getConfirmPassword());
        riderRepository.save(rider);
        SignUpRiderResponse response = new SignUpRiderResponse();
        response.setMessage("Registration Successful");

        return response;
    }

    @Override
    public LoginRiderResponse login(LoginRequest request) {
        return null;
    }

    private void validate(SignUpRiderRequest request) {
        if (riderRepository.findRiderByEmail(request.getEmail()) != null) {
            throw new RiderAlreadyExistException("Rider with this email already exists");
        }
        if (riderRepository.findRiderByPhoneNumber(request.getPhoneNumber()) != null) {
            throw new RiderAlreadyExistException("Rider with this phone number already exists");

        }
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            throw new PasswordMismatchException("Passwords do not match");
        }
    }
}

