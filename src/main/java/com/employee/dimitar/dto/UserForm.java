package com.employee.dimitar.dto;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

/**
 * The UserForm class represents a form for user details.
 */
@Validated
public class UserForm {

    /**
     * The first name of the user.
     */
    @NotNull
    @NotBlank(message = "First name is required")
    @Size(max = 20)
    private String firstName;

    /**
     * The last name of the user.
     */
    @NotNull
    @NotBlank(message = "Last name is required")
    @Size(max = 20)
    private String lastName;

    /**
     * The email address (username) of the user.
     */
    @NotNull
    @NotBlank(message = "Email is required")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE, message = "Invalid email address")
    private String username;

    /**
     * The password of the user.
     */
    @NotNull
    @NotBlank(message = "Password is required")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$",
            message = "Your new password should have " +
                    "at least one upper case English letter, " +
                    "at least one lower case English letter, " +
                    "at least one digit, " +
                    "at least one special character," +
                    " minimum eight in length")
    private String password;

    /**
     * The role of the user.
     */
    @NotNull
    @NotBlank(message = "Role is required")
    @Pattern(regexp = "(ROLE_ADMIN)|(ROLE_USER)",
            message = "User role must be: ROLE_USER or ROLE_ADMIN")
    private String role;

    /**
     * Default constructor.
     */
    public UserForm() {}

    /**
     * Constructs a UserForm object with the specified parameters.
     *
     * @param firstName The first name of the user.
     * @param lastName  The last name of the user.
     * @param username  The email address (username) of the user.
     * @param password  The password of the user.
     * @param role      The role of the user.
     */
    public UserForm(String firstName, String lastName, String username, String password, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /**
     * Retrieves the first name of the user.
     *
     * @return The first name of the user.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Retrieves the last name of the user.
     *
     * @return The last name of the user.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Retrieves the email address (username) of the user.
     *
     * @return The email address (username) of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Retrieves the password of the user.
     *
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Retrieves the role of the user.
     *
     * @return The role of the user.
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the first name of the user.
     *
     * @param firstName The first name of the user.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the last name of the user.
     *
     * @param lastName The last name of the user.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the email address (username) of the user.
     *
     * @param username The email address (username) of the user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the password of the user.
     *
     * @param password The password of the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the role of the user.
     *
     * @param role The role of the user.
     */
    public void setRole(String role) {
        this.role = role;
    }
}
