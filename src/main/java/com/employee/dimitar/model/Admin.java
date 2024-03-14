package com.employee.dimitar.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * The Admin class represents an administrator user.
 */
@JsonTypeName("ROLE_ADMIN")
@Entity
@DiscriminatorValue("ROLE_ADMIN")
public class Admin extends Guest{
    /**
     * Default constructor.
     */
    public Admin(){
        super();
    }

    /**
     * Constructs an Admin object from a Guest object.
     *
     * @param guest The Guest object.
     */
    public Admin(Guest guest) {
        super(guest);
    }

    /**
     * Constructs an Admin object with the specified parameters.
     *
     * @param username  The username of the admin.
     * @param password  The password of the admin.
     * @param firstName The first name of the admin.
     * @param lastName  The last name of the admin.
     */
    public Admin(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName, Role.ROLE_ADMIN);
    }

    /**
     * Constructs an Admin object with the specified parameters.
     *
     * @param id        The ID of the admin.
     * @param username  The username of the admin.
     * @param password  The password of the admin.
     * @param firstName The first name of the admin.
     * @param lastName  The last name of the admin.
     */
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Admin(@JsonProperty("id") Long id, @JsonProperty("username") String username, @JsonProperty("password") String password, @JsonProperty("first_name") String firstName, @JsonProperty("last_name") String lastName) {
        super(id, username, password, firstName, lastName, Role.ROLE_ADMIN);
    }
}
