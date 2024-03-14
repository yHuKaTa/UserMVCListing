package com.employee.dimitar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * The LoginDetailsService class provides user details service for authentication during login.
 */
@Service
public class LoginDetailsService implements UserDetailsService {
    /**
     * The UserService instance for user-related operations.
     */
    private final UserService service;

    /**
     * Constructs a LoginDetailsService object with the specified UserService.
     *
     * @param service The UserService instance.
     */
    @Autowired
    public LoginDetailsService(UserService service) {
        this.service = service;
    }

    /**
     * Loads user details by username for authentication during login.
     *
     * @param username The username of the user to load.
     * @return The UserDetails object representing the user.
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        return service.loginCheck(username);
    }
}
