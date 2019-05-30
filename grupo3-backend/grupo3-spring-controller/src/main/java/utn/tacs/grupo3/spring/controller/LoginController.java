package utn.tacs.grupo3.spring.controller;

import utn.tacs.grupo3.model.User;

public interface LoginController {
    /**
     * Registers a new user
     *
     * @param user
     */
    void createUser(User user);
}
