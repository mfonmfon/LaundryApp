package com.semicolon.africa.laundryluxe.services;

import com.semicolon.africa.laundryluxe.data.model.Customer;
import com.semicolon.africa.laundryluxe.data.repository.CustomerRepository;
import com.semicolon.africa.laundryluxe.dto.request.SignupCustomerRequest;
import com.semicolon.africa.laundryluxe.dto.request.LoginCustomerRequest;
import com.semicolon.africa.laundryluxe.dto.response.LoginCustomerResponse;
import com.semicolon.africa.laundryluxe.dto.response.SignUpCustomerResponse;
import com.semicolon.africa.laundryluxe.exceptions.EmailDoesNotExistException;
import com.semicolon.africa.laundryluxe.exceptions.EmptyFeildsException;
import com.semicolon.africa.laundryluxe.exceptions.PasswordNotExistException;
import com.semicolon.africa.laundryluxe.exceptions.UnMatchablePassword;
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
        if (signupCustomerRequest.getPassword() != signupCustomerRequest.getConfirmPassword()){
            throw new UnMatchablePassword("Password mismatch");
        }
        validatePassword(signupCustomerRequest.getPassword());
        customer = customerRepository.save(customer);
        signupCustomerMapper(signupCustomerRequest, customer);
        return signUpCustomerResponseMapper(customer);
    }
    private Customer findCustomerByEmail(String email) {
        return customerRepository.findByEmailIgnoreCase(email).
                orElseThrow(()-> new EmailDoesNotExistException("Email does not exist"));
    }
    private void validatePassword(String password) {
        for (Customer customerPassword: customerRepository.findAll()){
            if (customerPassword.getPassword() != password){
                throw new PasswordNotExistException("Does not exist");
            }
        }
    }
    private boolean isValueIsNullOrEmpty(String value) {
        return value == null  || value.trim().isEmpty();
    }
    @Override
    public LoginCustomerResponse loginCustomer(LoginCustomerRequest loginCustomerRequest) {
        findCustomerByEmail(loginCustomerRequest.getEmail());
        Customer customer = new Customer();

        customer.setEmail(loginCustomerRequest.getEmail());
        customer.setPassword(loginCustomerRequest.getPassword());
        customerRepository.save(customer);
        LoginCustomerResponse loginCustomerResponse = new LoginCustomerResponse();
        loginCustomerResponse.setLoggedIn(true);
        loginCustomerResponse.setMessage("Login successfully");
        return loginCustomerResponse;
    }
}
