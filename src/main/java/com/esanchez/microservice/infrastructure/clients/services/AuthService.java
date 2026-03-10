package com.esanchez.microservice.infrastructure.clients.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.esanchez.microservice.infrastructure.clients.AuthMicroserviceFeign;
import com.esanchez.microservice.infrastructure.clients.dto.AuthRequestDTO;
import com.esanchez.microservice.infrastructure.clients.dto.AuthResponseDTO;

@Service
public class AuthService {

	private static final Logger logger = LogManager.getLogger(AuthService.class);
	
	@Value("${auth-microservice.user}")
	private String username;

	@Value("${auth-microservice.pass}")
	private String password;
	
    private final AuthMicroserviceFeign authMicroserviceFeign;
    
    private static String cachedToken;

    public AuthService(AuthMicroserviceFeign authMicroserviceFeign) {
        this.authMicroserviceFeign = authMicroserviceFeign;
    }

    public synchronized String getJwtToken() {
        if (cachedToken != null) {
            return cachedToken;
        }
        
        AuthRequestDTO authRequestDTO = new AuthRequestDTO.Builder()
        												.username(username)
        												.password(password)
        												.build();
        
        AuthResponseDTO response = authMicroserviceFeign.authenticate(authRequestDTO);
        cachedToken = response.getBody().getToken();
        
        logger.info("JWT obtained: {}", cachedToken);
        
        return cachedToken;
    }
    
    public synchronized void invalidateToken() {
    	cachedToken = null;
    }
}
