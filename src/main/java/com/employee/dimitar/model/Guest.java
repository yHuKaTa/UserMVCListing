package com.employee.dimitar.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;


/**
 * The abstract Guest class represents a user entity with basic user details.
 */
@Table(name = "users")
@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "role")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Admin.class, name = "ROLE_ADMIN"),
        @JsonSubTypes.Type(value = User.class, name = "ROLE_USER")
})
@DiscriminatorColumn(name = "role")
public abstract class Guest implements UserDetails {

    /**
     * The ID of the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The username of the user.
     */
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    /**
     * The password of the user.
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * The first name of the user.
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * The last name of the user.
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * The role of the user.
     */
    @Column(name = "role", nullable = false, insertable = false, updatable = false)
    @Enumerated(value = EnumType.STRING)
    private Role role;

    /**
     * Default constructor.
     */
    public Guest() {}

    /**
     * Copy Constructor: Constructs a Guest object from another Guest object.
     *
     * @param guest The Guest object to copy.
     */
    public Guest(Guest guest) {
        this.id = guest.getId();
        this.username = guest.username;
        this.password = guest.password;
        this.firstName = guest.firstName;
        this.lastName = guest.lastName;
        this.role = guest.role;
    }

    /**
     * Constructs a Guest object with the specified parameters.
     *
     * @param id        The ID of the user.
     * @param username  The username of the user.
     * @param password  The password of the user.
     * @param firstName The first name of the user.
     * @param lastName  The last name of the user.
     * @param role      The role of the user.
     */
    public Guest(Long id, String username, String password, String firstName, String lastName, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    /**
     * Constructs a Guest object with the specified parameters.
     *
     * @param username  The username of the user.
     * @param password  The password of the user.
     * @param firstName The first name of the user.
     * @param lastName  The last name of the user.
     * @param role      The role of the user.
     */
    public Guest(String username, String password, String firstName, String lastName, Role role) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    /**
     * Retrieves the ID of the user.
     *
     * @return The ID of the user.
     */
    public Long getId() {
        return id;
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
     * Retrieves the role of the user.
     *
     * @return The role of the user.
     */
    public Role getRole() {
        return role;
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
     * Retrieves the email of the user.
     *
     * @return The email of the user.
     */
    @Override
    public String getUsername() {
        return this.username;
    }

    /**
     * Checks if the user account is non-expired.
     *
     * @return only true at this moment.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Checks if the user account is non-locked.
     *
     * @return only true at this moment.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Checks if the user credentials are non-expired.
     *
     * @return only true at this moment.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Checks if the guest account is enabled.
     *
     * @return only true at this moment.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }


    /**
     * Retrieves the authorities granted to the user.
     *
     * @return The authorities granted to the user.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.getRole().role()));
    }

    /**
     * Checks if this guest object is equal to another object.
     *
     * @param o The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guest)) return false;
        Guest guest = (Guest) o;
        return Objects.equals(id, guest.id) && Objects.equals(username, guest.username);
    }

    /**
     * Computes the hash code for this guest object.
     *
     * @return The hash code value for this guest object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, firstName, lastName, role);
    }
}
