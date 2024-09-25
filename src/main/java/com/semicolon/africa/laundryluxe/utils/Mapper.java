package com.semicolon.africa.laundryluxe.utils;

import com.semicolon.africa.laundryluxe.data.model.Customer;
import com.semicolon.africa.laundryluxe.dto.request.SendCustomerOrderRequest;
import com.semicolon.africa.laundryluxe.dto.request.SignupCustomerRequest;
import com.semicolon.africa.laundryluxe.dto.response.SendCustomerOrderResponse;
import com.semicolon.africa.laundryluxe.dto.response.SignUpCustomerResponse;
import com.semicolon.africa.laundryluxe.exceptions.InvalidEmailException;

public class Mapper {

    public static void signupCustomerMapper(SignupCustomerRequest signupCustomerRequest, Customer customer) {
        customer.setFirstName(signupCustomerRequest.getFirstName());
        customer.setLastName(signupCustomerRequest.getLastName());
        customer.setEmail(signupCustomerRequest.getEmail());
        customer.setPhoneNumber(signupCustomerRequest.getPhoneNumber());
        customer.setPassword(signupCustomerRequest.getPassword());
        customer.setConfirmPassword(signupCustomerRequest.getConfirmPassword());
        if (signupCustomerRequest.getEmail() == "@") {
            throw new InvalidEmailException("Missing @ in your email");

        }
        if (signupCustomerRequest.getEmail() == ".") {
            throw new InvalidEmailException("Missing . in your email");
        }
    }


    public static SignUpCustomerResponse signUpCustomerResponseMapper(Customer customer) {
        SignUpCustomerResponse signUpCustomerResponse = new SignUpCustomerResponse();
        signUpCustomerResponse.setCustomerId(customer.getId());
        signUpCustomerResponse.setFirstName(customer.getFirstName());
        signUpCustomerResponse.setLastName(customer.getLastName());
        signUpCustomerResponse.setEmail(customer.getEmail());
        signUpCustomerResponse.setPhoneNumber(customer.getPhoneNumber());
        signUpCustomerResponse.setPassword(customer.getPassword());
        signUpCustomerResponse.setConfirmPassword(customer.getConfirmPassword());
        signUpCustomerResponse.setMessage("Successfully signup");
        return signUpCustomerResponse;
    }

    public static void sendOrderRequestMapper(SendCustomerOrderRequest sendCustomerOrderRequest, Customer customer) {
        customer.setFirstName(sendCustomerOrderRequest.getFirstName());
        customer.setLastName(sendCustomerOrderRequest.getLastName());
        customer.setEmail(sendCustomerOrderRequest.getEmail());
        customer.setPhoneNumber(sendCustomerOrderRequest.getPhoneNumber());
        customer.setHomeAddress(sendCustomerOrderRequest.getHomeAddress());
        customer.setSpecialInstructions(sendCustomerOrderRequest.getSpecialInstructions());
        customer.setSendAt(sendCustomerOrderRequest.getCreatedAt());
    }

    public static SendCustomerOrderResponse getSendCustomerOrderResponse(Customer customer) {
        SendCustomerOrderResponse sendCustomerOrderResponse = new SendCustomerOrderResponse();
        sendCustomerOrderResponse.setFirstName(customer.getFirstName());
        sendCustomerOrderResponse.setLastName(customer.getLastName());
        sendCustomerOrderResponse.setEmail(customer.getEmail());
        sendCustomerOrderResponse.setPhoneNumber(customer.getPhoneNumber());
        sendCustomerOrderResponse.setHomeAddress(customer.getHomeAddress());
        sendCustomerOrderResponse.setSpecialInstructions(customer.getSpecialInstructions());
        sendCustomerOrderResponse.setMessage("Just Ordered");
        return sendCustomerOrderResponse;
    }

}
