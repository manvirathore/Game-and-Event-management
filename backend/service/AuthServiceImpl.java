package com.fitrack.demo.service;

import com.fitrack.demo.DTO.AuthRequest;
import com.fitrack.demo.DTO.AuthResponse;
import com.fitrack.demo.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserAuthDetailService userAuthDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;


    public ResponseEntity<AuthResponse> authenticateUser(AuthRequest authRequest) throws Exception {

        authenticate(authRequest.getUsername(), authRequest.getPassword());

        final UserDetails userDetails = userAuthDetailsService
                .loadUserByUsername(authRequest.getUsername());
        final String token = jwtUtils.generateJwtToken(userDetails);
        return ResponseEntity.ok(AuthResponse.builder().token(token).tokenType("Bearer").build());
    }

    public void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("INVALID_CREDENTIALS", e);
        }
    }
}
