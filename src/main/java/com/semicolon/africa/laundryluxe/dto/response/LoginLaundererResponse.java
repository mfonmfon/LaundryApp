package com.semicolon.africa.laundryluxe.dto.response;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginLaundererResponse {
    private String message;
    private boolean isLoggedIn;
}
