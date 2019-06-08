package utn.tacs.grupo3.spring.controller;

import utn.tacs.grupo3.model.User;
import utn.tacs.grupo3.model.exception.signUpValidation.ExceptionbySignUpValidation;

public interface LoginController {
    /**
     * Registers a new user
     *
     * @param user
     */
    void createUser(User user) throws ExceptionbySignUpValidation;
}
