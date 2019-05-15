package utn.tacs.grupo3.spring.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import utn.tacs.grupo3.model.User;
import utn.tacs.grupo3.repository.UserRepository;
import utn.tacs.grupo3.spring.controller.LoginController;

@RestController
public class LoginControllerImpl implements LoginController {
    @Autowired
    private UserRepository userRepository;

    @Override
    @PostMapping(path = "/sign-up")
    public String createUser(@RequestBody User user) {
        userRepository.createUser(user);
        return "Usuario creado correctamente.";
    }
}
