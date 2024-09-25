package com.semicolon.africa.laundryluxe.services;

import com.semicolon.africa.laundryluxe.data.model.Customer;
import com.semicolon.africa.laundryluxe.data.repository.CustomerRepository;
import com.semicolon.africa.laundryluxe.dto.request.SendCustomerOrderRequest;
import com.semicolon.africa.laundryluxe.dto.request.SignupCustomerRequest;
import com.semicolon.africa.laundryluxe.dto.request.LoginCustomerRequest;
import com.semicolon.africa.laundryluxe.dto.request.UpdateCustomerOrderRequest;
import com.semicolon.africa.laundryluxe.dto.response.*;
import com.semicolon.africa.laundryluxe.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.semicolon.africa.laundryluxe.utils.Mapper.*;

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
        if (!(customer.getConfirmPassword() == customer.getPassword())){
            throw new UnMatchablePassword("Password mismatch");
        }

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

    @Override
    public SendCustomerOrderResponse sendOrder(SendCustomerOrderRequest sendCustomerOrderRequest) {
        validatePhoneNumber(sendCustomerOrderRequest.getPhoneNumber());
        Customer customer = new Customer();
        if (isValueIsNullOrEmpty(sendCustomerOrderRequest.getFirstName())||
            isValueIsNullOrEmpty(sendCustomerOrderRequest.getLastName())||
            isValueIsNullOrEmpty(sendCustomerOrderRequest.getEmail())||
            isValueIsNullOrEmpty(sendCustomerOrderRequest.getPhoneNumber())||
            isValueIsNullOrEmpty(sendCustomerOrderRequest.getHomeAddress())||
            isValueIsNullOrEmpty(sendCustomerOrderRequest.getSpecialInstructions())){

            throw new EmptyFeildsException("Please fill all the fields");
        }
        if (!(sendCustomerOrderRequest.getEmail().contains("@")||
                sendCustomerOrderRequest.getEmail().contains("."))){
            throw new InvalidEmailException("Invalid email or password");

        }
        sendOrderRequestMapper(sendCustomerOrderRequest, customer);
        customerRepository.save(customer);
        return getSendCustomerOrderResponse(customer);
    }

    @Override
    public UpdateCustomerOrderResponse updateOrder(UpdateCustomerOrderRequest customerOrderRequest) {
        Customer customer = new Customer();
        customer.setFirstName(customer.getFirstName());

        return null;
    }

    @Override
    public DeleteSenderOrderResponse deleteOrder(Long id) {
        return null;
    }

    private void validatePhoneNumber(String phoneNumber) {
        for (Customer customerPhoneNumber: customerRepository.findAll()){
            if (customerPhoneNumber.getPhoneNumber() != phoneNumber){
                throw new PhoneNumberAlreadyExistException("This phone number already exist please try another phone number ");

            }
        }
    }

}
