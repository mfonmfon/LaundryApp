package com.semicolon.africa.laundryluxe.data.repository;

import com.semicolon.africa.laundryluxe.data.model.Launderer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaundererRepository extends JpaRepository<Launderer, Long> {
Launderer findByEmail(String email);
Launderer findByEmailAndPassword(String email, String password);
}
