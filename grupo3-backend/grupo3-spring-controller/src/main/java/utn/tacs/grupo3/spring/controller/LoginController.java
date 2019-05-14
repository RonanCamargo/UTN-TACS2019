package utn.tacs.grupo3.spring.controller;

import utn.tacs.grupo3.model.User;

/**
 * Interface for login-related controller methods
 */
public interface LoginController {
    User register(User user);
}