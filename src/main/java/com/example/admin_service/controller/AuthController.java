package com.example.admin_service.controller;

import com.example.admin_service.util.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/auth")
public class AuthController {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
       
        
        if ("admin".equals(loginRequest.getUsername()) && 
            "password".equals(loginRequest.getPassword())) {
            
            Map<String, Object> claims = new HashMap<>();
            claims.put("role", "ADMIN");
            
            String token = tokenProvider.generateToken(loginRequest.getUsername(), claims);
            
            return ResponseEntity.ok(new LoginResponse(token, "admin"));
        }
        
        return ResponseEntity.badRequest().body(new ErrorResponse("Invalid credentials"));
    }

    public static class LoginRequest {
        private String username;
        private String password;

        public LoginRequest() {}

        public LoginRequest(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public static class LoginResponse {
        private String token;
        private String username;

        public LoginResponse(String token, String username) {
            this.token = token;
            this.username = username;
        }

        public String getToken() {
            return token;
        }

        public String getUsername() {
            return username;
        }
    }

    public static class ErrorResponse {
        private String message;

        public ErrorResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
