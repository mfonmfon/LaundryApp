package com.semicolon.africa.laundryluxe.services;

import com.semicolon.africa.laundryluxe.data.model.Customer;
import com.semicolon.africa.laundryluxe.data.repository.CustomerRepository;
import com.semicolon.africa.laundryluxe.dto.request.SignupCustomerRequest;
import com.semicolon.africa.laundryluxe.dto.response.LoginCustomerRequest;
import com.semicolon.africa.laundryluxe.dto.response.LoginCustomerResponse;
import com.semicolon.africa.laundryluxe.dto.response.SignUpCustomerResponse;
import com.semicolon.africa.laundryluxe.exceptions.EmptyFeildsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.semicolon.africa.laundryluxe.utils.Mapper.signUpCustomerResponseMapper;
import static com.semicolon.africa.laundryluxe.utils.Mapper.signupCustomerMapper;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private  CustomerRepository customerRepository;

    @Override
    public SignUpCustomerResponse signupCustomer(SignupCustomerRequest signupCustomerRequest) {
        Customer customer = new Customer();
        if (isValueIsNullOrEmpty(signupCustomerRequest.getFirstName())||
                isValueIsNullOrEmpty(signupCustomerRequest.getLastName())||
                isValueIsNullOrEmpty(signupCustomerRequest.getEmail())||
                isValueIsNullOrEmpty(signupCustomerRequest.getPhoneNumber())||
                isValueIsNullOrEmpty(signupCustomerRequest.getPassword())||
                isValueIsNullOrEmpty(signupCustomerRequest.getConfirmPassword())){
            throw new EmptyFeildsException("Please enter all the fields");
        }
        customer = customerRepository.save(customer);
        signupCustomerMapper(signupCustomerRequest, customer);
        return signUpCustomerResponseMapper(customer);
    }

    private boolean isValueIsNullOrEmpty(String value) {
        return value == null  || value.trim().isEmpty();
    }

    @Override
    public LoginCustomerResponse loginCustomer(LoginCustomerRequest loginCustomerRequest) {
        return null;
    }
}
