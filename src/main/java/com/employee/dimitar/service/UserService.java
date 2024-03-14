package com.employee.dimitar.service;

import com.employee.dimitar.dto.GuestConvertor;
import com.employee.dimitar.dto.UserForm;
import com.employee.dimitar.model.Guest;
import com.employee.dimitar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;

/**
 * The UserService class provides user-related operations.
 */
@Service
public class UserService {
    /**
     * The UserRepository instance for accessing user data in the database.
     */
    private UserRepository repository;

    /**
     * Constructs a UserService object with the specified UserRepository.
     *
     * @param repository The UserRepository instance.
     */
    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * Checks user credentials during login and returns UserDetails.
     *
     * @param username The username of the user to check.
     * @return The UserDetails object representing the user.
     * @throws UsernameNotFoundException If the user with the specified username is not found.
     */
    public UserDetails loginCheck(String username) {
            return repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Bad credentials"));
    }

    /**
     * Adds a new user.
     *
     * @param userForm The UserForm containing user details.
     * @throws EntityExistsException If a user with the same username already exists.
     */
    public void addUser(UserForm userForm) {
        if (repository.existsByUsername(userForm.getUsername())){
            throw new EntityExistsException("Unable to register user!");
        }
        Guest user = GuestConvertor.toUser(userForm);
        repository.save(user);
    }

    /**
     * Retrieves a list of all users.
     *
     * @return A list of all users.
     */
    public List<Guest> getAllUsers() {
        return repository.findAll();
    }

    /**
     * Deletes a user by ID.
     *
     * @param id The ID of the user to delete.
     */
    public void deleteUser(Long id) {
        if (repository.existsById(id) && !(getUser(id).getUsername().equals("admin"))) {
                repository.deleteById(id);
        }
    }

    /**
     * Retrieves a user by ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The Object representing the user itself. Will return User or Admin object.
     * @throws UsernameNotFoundException If the user with the specified ID is not found.
     */
    private Guest getUser(Long id) {
        return repository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
    }
}
