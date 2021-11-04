package com.eindproject.v4.controllers;

import com.eindproject.v4.payload.AuthenticationRequest;
import com.eindproject.v4.payload.AuthenticationResponse;
import com.eindproject.v4.service.UserAuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    UserAuthenticateService userAuthenticateService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        AuthenticationResponse authenticationResponse = userAuthenticateService.authenticateUser(authenticationRequest);
        return ResponseEntity.ok(authenticationResponse);
    }
}
