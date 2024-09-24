package com.semicolon.africa.laundryluxe.data.repository;

import com.semicolon.africa.laundryluxe.data.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
