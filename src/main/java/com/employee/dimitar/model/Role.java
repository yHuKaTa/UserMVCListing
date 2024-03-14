package com.employee.dimitar.model;

/**
 * The Role enum represents user roles.
 */
public enum Role {
    /**
     * Role for regular users.
     */
    ROLE_USER("ROLE_USER"),

    /**
     * Role for administrators.
     */
    ROLE_ADMIN("ROLE_ADMIN");

    /**
     * The role name.
     */
    private final String role;

    /**
     * Used to create Role enum constant with the specified String.
     *
     * @param role The role name.
     */
    Role(String role) {
        this.role = role;
    }

    /**
     * Retrieves the role name.
     *
     * @return The role name.
     */
    public String role() {
        return role;
    }
}
