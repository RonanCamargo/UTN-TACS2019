package utn.tacs.grupo3.spring.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import utn.tacs.grupo3.model.User;
import utn.tacs.grupo3.spring.controller.LoginController;
import utn.tacs.grupo3.spring.service.SecurityService;
import utn.tacs.grupo3.spring.service.UserService;


@RestController
@RequestMapping("/security")
public class LoginControllerImpl implements LoginController {
    @Autowired
    UserService userService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    SecurityService securityService;

    @PostMapping("/register")
    public User register(@RequestBody User newUser) {
        String password = newUser.getPassword();
        String username = newUser.getUsername();
        User user = userService.create(newUser);

        // Para hacer el login hay que usar el password antes de hashearlo
        securityService.autoLogin(username, password);

        return user;
    }
}