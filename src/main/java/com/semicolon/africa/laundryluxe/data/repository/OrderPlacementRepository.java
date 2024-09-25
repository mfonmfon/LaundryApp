package com.semicolon.africa.laundryluxe.data.repository;

import com.semicolon.africa.laundryluxe.data.model.OrderPlacement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderPlacementRepository extends JpaRepository<OrderPlacement, Long> {
}
