package com.semicolon.africa.laundryluxe.services;
import com.semicolon.africa.laundryluxe.data.repository.RiderRepository;
import com.semicolon.africa.laundryluxe.dto.request.SignUpRiderRequest;
import com.semicolon.africa.laundryluxe.dto.response.SignUpRiderResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RiderServiceImplTest {


    @Autowired
    private RiderServiceImpl riderServiceImpl;
    @Autowired
    private RiderRepository riderRepository;


    @Test
    public void testThatRiderCanSignUp() {
        SignUpRiderRequest signUp = new SignUpRiderRequest();
        signUp.setFirstName("Ken");
        signUp.setLastName("Johnson");
        signUp.setEmail("Ken@gmail.com");
        signUp.setAddress("Mombasa");
        signUp.setPhoneNumber("08123456789");
        signUp.setPassword("123456");
        signUp.setConfirmPassword("123456");
        var res = riderServiceImpl.signUpRider(signUp);
        assertEquals(1,riderRepository.count());


    }

}
