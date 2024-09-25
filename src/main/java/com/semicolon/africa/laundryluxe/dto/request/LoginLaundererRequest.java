package com.semicolon.africa.laundryluxe.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginLaundererRequest {
    private String email;
    private String password;
}
