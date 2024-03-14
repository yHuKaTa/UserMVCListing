package com.employee.dimitar.controller;

import com.employee.dimitar.dto.UserForm;
import com.employee.dimitar.model.Guest;
import com.employee.dimitar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * The UserController class handles user-related operations and mappings.
 */
@Controller
@SessionAttributes("SPRING_SECURITY_CONTEXT")
public class UserController {

    /**
     * The UserService instance.
     */
    private UserService service;

    /**
     * Constructs a UserController object with the specified UserService.
     *
     * @param service The UserService instance.
     */
    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    /**
     * Displays the home page.
     *
     * @param model   The ModelAndView object.
     * @param session The HttpSession object.
     * @return The ModelAndView object for the home page.
     */
    @GetMapping("/home")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView showHomePage(ModelAndView model, HttpSession session) {
        SecurityContext attributes = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
        Guest loggedInUser = (Guest) attributes.getAuthentication().getPrincipal();
        List<Guest> userList = service.getAllUsers();
        model.addObject("user", loggedInUser);
        model.addObject("userList", userList);
        model.setViewName("home");
        return model;
    }

    /**
     * Adds a new user.
     *
     * @param userForm            The UserForm object containing user details.
     * @param result              The BindingResult object for validation results.
     * @return The ModelAndView object for redirection.
     */
    @PostMapping("/addUser")
    @PreAuthorize("isAuthenticated() and hasRole('ROLE_ADMIN')")
    public ModelAndView addUser(@ModelAttribute("addUserForm") @Valid UserForm userForm, BindingResult result) {
        if (result.hasErrors()) {
            //TODO Implement validation response in view
            return new ModelAndView("redirect:/userForm");
        }
        service.addUser(userForm);
        return new ModelAndView("redirect:/home");
    }


    /**
     * Displays the form for adding a new user.
     *
     * @param model The ModelAndView object.
     * @return The ModelAndView object for the user form page.
     */
    @GetMapping("/userForm")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView showAddUser(ModelAndView model) {
        model.addObject("addUserForm",  new UserForm());
        model.setViewName("userForm");
        return model;
    }

    /**
     * Deletes a user by ID.
     *
     * @param id                  The ID of the user to delete.
     * @return The ModelAndView object for redirection.
     */
    @DeleteMapping("/deleteUser/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView deleteUser(@PathVariable @Pattern(regexp = "\\d+", message = "Please enter a valid user ID (numeric value only).") @Valid Long id) {
        service.deleteUser(id);
        return new ModelAndView("redirect:/home");
    }
}
