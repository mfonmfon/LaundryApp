package com.semicolon.africa.laundryluxe.services;

import com.semicolon.africa.laundryluxe.dto.request.*;
import com.semicolon.africa.laundryluxe.dto.response.*;

public interface CustomerService {

    SignUpCustomerResponse signupCustomer(SignupCustomerRequest signupCustomerRequest);

    LoginCustomerResponse loginCustomer(LoginCustomerRequest loginCustomerRequest);

    SendCustomerOrderResponse sendOrder(SendCustomerOrderRequest sendCustomerOrderRequest);

    UpdateCustomerOrderResponse updateOrder(UpdateCustomerOrderRequest customerOrderRequest);

    DeleteSenderOrderResponse deleteOrder(Long id );

}
