package com.semicolon.africa.laundryluxe.data.repository;

import com.semicolon.africa.laundryluxe.data.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
