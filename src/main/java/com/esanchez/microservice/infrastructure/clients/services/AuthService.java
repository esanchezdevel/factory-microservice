package com.esanchez.microservice.infrastructure.clients.services;

import org.springframework.stereotype.Service;

import com.esanchez.microservice.infrastructure.clients.dto.AuthResponse;

@Service
public class AuthService {

    private final AuthClientFeign authClientFeign;
    private String cachedToken;
    private long expiryTime;

    public AuthService(AuthClientFeign authClientFeign) {
        this.authClientFeign = authClientFeign;
    }

    public synchronized String getJwtToken() {
        if (cachedToken != null && System.currentTimeMillis() < expiryTime) {
            return cachedToken;
        }

        AuthResponse response = authClientFeign.authenticate();
        cachedToken = response.token();
        expiryTime = System.currentTimeMillis() + (response.getExpiresIn() * 1000) - 10000;
        return cachedToken;
    }
}
