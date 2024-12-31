package com.fitrack.demo.service;

import com.fitrack.demo.model.User;
import com.fitrack.demo.model.UserAuthDetails;
import com.fitrack.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username) // Replace with correct findBy method
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserAuthDetails.build(user);
    }


}
