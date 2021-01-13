package com.manav.api.services;

import com.manav.api.models.CustomUserDetails;
import com.manav.api.models.User;
import com.manav.api.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailServices implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        if (!user.isPresent())
            throw new UsernameNotFoundException(username + " Not Found.");
        else
            return user.map(CustomUserDetails::new).get();
    }
}
