package com.employee.dimitar.dto;

import com.employee.dimitar.model.Admin;
import com.employee.dimitar.model.Guest;
import com.employee.dimitar.model.User;
import com.employee.dimitar.util.Encoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * The GuestConvertor class provides methods for converting UserForm objects to Guest objects.
 */
public class GuestConvertor {
    /**
     * The BCryptPasswordEncoder instance for password encoding.
     */
    private static BCryptPasswordEncoder encoder = Encoder.getEncoder();

    /**
     * Converts a UserForm to a Guest object.
     *
     * @param userForm The UserForm object to convert.
     * @return A Guest object based on the UserForm data.
     */
    public static Guest toUser(UserForm userForm) {
        if (userForm.getRole().equals("ROLE_ADMIN")) {
            return new Admin(userForm.getUsername(), encoder.encode(userForm.getPassword()), userForm.getFirstName(), userForm.getLastName());
        }
        return new User(userForm.getUsername(), encoder.encode(userForm.getPassword()), userForm.getFirstName(), userForm.getLastName());
    }
}
