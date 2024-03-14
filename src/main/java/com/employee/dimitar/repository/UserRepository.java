package com.employee.dimitar.repository;

import com.employee.dimitar.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * The UserRepository interface provides methods for accessing and managing Guest object entities in the database.
 */
public interface UserRepository extends JpaRepository<Guest, Long> {
    /**
     * Retrieves a guest object by username.
     *
     * @param username The username of the user.
     * @return An Optional containing the guest object if found, empty otherwise.
     */
    Optional<Guest> findByUsername(String username);

    /**
     * Checks if a guest object exists with the specified username.
     *
     * @param username The username to check.
     * @return true if a guest object with the username exists, false otherwise.
     */
    @Query("select (count(g) >= 1) from Guest g where g.username = ?1")
    boolean existsByUsername(String username);
}
