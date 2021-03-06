package com.project.authorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.authorization.entity.AuthRequest;
import com.project.authorization.util.JwtUtil;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class WelcomeController {
	

	
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;



    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
        	
        	authenticationManager.authenticate(
        			new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
                    
            );
            
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUsername());
    }
    
    @GetMapping("/validate")
    public Boolean validateToken(
    		@RequestHeader("Authorization") String token
    		) {
    	return jwtUtil.validateJwtToken(token);
    	
    		
    }
    

}
