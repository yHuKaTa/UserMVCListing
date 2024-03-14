package com.employee.dimitar.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * The User class represents a regular user entity.
 */
@JsonTypeName("ROLE_USER")
@Entity
@DiscriminatorValue("ROLE_USER")
public class User extends Guest{
    /**
     * Default constructor.
     */
    public User(){
        super();
    }

    /**
     * Constructs a User object from a Guest object.
     *
     * @param guest The Guest object.
     */
    public User(Guest guest) {
        super(guest);
    }

    /**
     * Constructs a User object with the specified parameters.
     *
     * @param username  The username of the user.
     * @param password  The password of the user.
     * @param firstName The first name of the user.
     * @param lastName  The last name of the user.
     */
    public User(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName, Role.ROLE_USER);
    }

    /**
     * Constructs a User object with the specified parameters.
     *
     * @param id        The ID of the user.
     * @param username  The username of the user.
     * @param password  The password of the user.
     * @param firstName The first name of the user.
     * @param lastName  The last name of the user.
     */
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public User(@JsonProperty("id") Long id, @JsonProperty("username") String username, @JsonProperty("password") String password, @JsonProperty("first_name") String firstName, @JsonProperty("last_name") String lastName) {
        super(id, username, password, firstName, lastName, Role.ROLE_USER);
    }
}
