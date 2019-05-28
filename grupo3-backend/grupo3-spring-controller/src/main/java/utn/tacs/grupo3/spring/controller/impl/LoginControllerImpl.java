package utn.tacs.grupo3.spring.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import utn.tacs.grupo3.model.User;
import utn.tacs.grupo3.repository.UserRepository;
import utn.tacs.grupo3.spring.controller.LoginController;
import utn.tacs.grupo3.spring.converter.ConvertToJson;

import java.util.Map;

@RestController
public class LoginControllerImpl implements LoginController {
    @Autowired
    private UserRepository userRepository;

    @Override
    @PostMapping(path = "/sign-up")
    public Map<String, String> createUser(@RequestBody User user) {
        user.initialize();
        userRepository.createUser(user);
        return ConvertToJson.start("Usuario creado correctamente.");
    }
}
