package com.employee.dimitar.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Objects;

/**
 * The Encoder class provides methods for encoding and matching passwords using BCryptPasswordEncoder.
 */
public class Encoder {
    private static BCryptPasswordEncoder encoder;

    private Encoder() {}

    /**
     * Returns the BCryptPasswordEncoder Singleton instance.
     *
     * @return The BCryptPasswordEncoder instance.
     */
    public synchronized static BCryptPasswordEncoder getEncoder() {
        if (Objects.isNull(encoder)) {
            encoder = new BCryptPasswordEncoder();
        }
        return encoder;
    }

    /**
     * Encodes the given password.
     *
     * @param pass The password to encode.
     * @return The encoded password.
     */
    public String encode(String pass) {
        return encoder.encode(pass);
    }

    /**
     * Matches the given raw password with the encoded password.
     *
     * @param raw  The raw password.
     * @param pass The encoded password.
     * @return true if the raw password matches the encoded password, false otherwise.
     */
    public boolean match(String raw, String pass) {
        return encoder.matches(raw, pass);
    }
}
