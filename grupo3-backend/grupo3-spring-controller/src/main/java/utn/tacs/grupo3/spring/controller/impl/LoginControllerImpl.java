package utn.tacs.grupo3.spring.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
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
        SecurityService securityService;

        @PostMapping("/register")
        public void register(@RequestBody User user) {
            userService.create(user.getUsername(), user.getPassword());

            securityService.autoLogin(user.getUsername(), user.getPassword());
        }
    }

