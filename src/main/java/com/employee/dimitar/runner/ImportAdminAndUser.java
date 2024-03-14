package com.employee.dimitar.runner;

import com.employee.dimitar.dto.GuestConvertor;
import com.employee.dimitar.dto.UserForm;
import com.employee.dimitar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * The ImportAdminAndUser class is responsible for importing initial admin and user data into the database if none exists.
 */
@Component
public class ImportAdminAndUser implements CommandLineRunner {
    /**
     * The UserRepository instance for accessing user data in the database.
     */
    private UserRepository repository;

    /**
     * Constructs an ImportAdminAndUser object with the specified UserRepository.
     *
     * @param repository The UserRepository instance.
     */
    @Autowired
    public ImportAdminAndUser(UserRepository repository) {
        this.repository = repository;
    }


    /**
     * Runs the import process during application startup.
     *
     * @param args The command-line arguments.
     * @throws Exception If an error occurs during the import process.
     */
    @Override
    public void run(String... args) throws Exception {
        if(repository.count() < 1) {
            repository.save(GuestConvertor.toUser(new UserForm("ADMIN","ADMINOV","admin", "admin", "ROLE_ADMIN")));
            repository.save(GuestConvertor.toUser(new UserForm("USER","USEROV","guest", "guest", "ROLE_USER")));
        }
    }
}
