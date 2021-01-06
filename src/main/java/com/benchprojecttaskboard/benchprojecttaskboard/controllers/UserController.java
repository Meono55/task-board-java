package com.benchprojecttaskboard.benchprojecttaskboard.controllers;

import com.benchprojecttaskboard.benchprojecttaskboard.config.JwtUtil;
import com.benchprojecttaskboard.benchprojecttaskboard.models.AuthenticationRequest;
import com.benchprojecttaskboard.benchprojecttaskboard.models.AuthenticationResponse;
import com.benchprojecttaskboard.benchprojecttaskboard.models.User;
import com.benchprojecttaskboard.benchprojecttaskboard.services.MyUserDetailServices;
import com.benchprojecttaskboard.benchprojecttaskboard.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailServices userDetailServices;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailServices
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
