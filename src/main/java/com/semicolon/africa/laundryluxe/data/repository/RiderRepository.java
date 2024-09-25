package com.semicolon.africa.laundryluxe.data.repository;

import com.semicolon.africa.laundryluxe.data.model.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiderRepository extends JpaRepository<Rider, Long> {
        Rider findRiderByEmail(String email);
        Rider findRiderByPhoneNumber(String phoneNumber);


}
