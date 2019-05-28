package utn.tacs.grupo3.spring.controller;

import utn.tacs.grupo3.model.User;

import java.util.Map;

public interface LoginController {
    /**
     * Registers a new user
     *
     * @param user
     * @return
     */
    Map<String, String> createUser(User user);
}
