package com.enstage.pg.standalone.models;

import com.enstage.pg.standalone.dao.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCredentialsDetailsService implements UserDetailsService {

    @Autowired
    UserCredentialsRepository userCredentialsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserCredentials> userCredentials = userCredentialsRepository.findByUsername(username);
        userCredentials.orElseThrow(() -> new UsernameNotFoundException("User "+username+" not found"));
        return userCredentials.map(UserCredentialsDetails::new).get();
    }
}
