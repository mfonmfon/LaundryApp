package com.semicolon.africa.laundryluxe.services;

import com.semicolon.africa.laundryluxe.data.repository.CustomerRepository;
import com.semicolon.africa.laundryluxe.dto.request.SignupCustomerRequest;
import com.semicolon.africa.laundryluxe.dto.request.LoginCustomerRequest;
import com.semicolon.africa.laundryluxe.dto.response.LoginCustomerResponse;
import com.semicolon.africa.laundryluxe.dto.response.SignUpCustomerResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerRepository.deleteAll();
    }
    @Test
    public void testThatCustomerCanSignupOnTheApp(){
        SignupCustomerRequest signupCustomerRequest = signupCustomerCreation();
        SignUpCustomerResponse signUpCustomerResponse  = customerService.signupCustomer(signupCustomerRequest);
        assertThat(signUpCustomerResponse).isNotNull();
        assertThat(signUpCustomerResponse.getMessage()).contains("Successfully signup");
    }

    private static SignupCustomerRequest signupCustomerCreation() {
        SignupCustomerRequest signupCustomerRequest = new SignupCustomerRequest();
        signupCustomerRequest.setFirstName("Christian");
        signupCustomerRequest.setLastName("Lucky");
        signupCustomerRequest.setEmail("christian@gmail.com");
        signupCustomerRequest.setPhoneNumber("09012457786");
        signupCustomerRequest.setPassword("1234");
        signupCustomerRequest.setConfirmPassword("1234");
        return signupCustomerRequest;
    }

    @Test
    public void testThatCustomerCanLoginAfterLoggingOut(){
        signupCustomerCreation();
        LoginCustomerRequest loginCustomerRequest = new LoginCustomerRequest();
        loginCustomerRequest.setEmail("mfon@gmail.com");
        loginCustomerRequest.setEmail("1234");
        LoginCustomerResponse loginCustomerResponse = customerService.loginCustomer(loginCustomerRequest);
        assertThat(loginCustomerResponse).isNotNull();
        assertThat(loginCustomerResponse.getMessage()).contains("Login successfully");
    }
}