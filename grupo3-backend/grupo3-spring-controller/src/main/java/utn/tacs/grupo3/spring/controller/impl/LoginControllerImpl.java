package utn.tacs.grupo3.spring.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import utn.tacs.grupo3.model.User;
import utn.tacs.grupo3.model.exception.signUpValidation.ExceptionbySignUpValidation;
import utn.tacs.grupo3.repository.mongo.UserRepository;
import utn.tacs.grupo3.spring.controller.LoginController;
import utn.tacs.grupo3.spring.validations.SignUpValidation;

@RestController
public class LoginControllerImpl implements LoginController {
  
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @PostMapping(path = "/sign-up")
    public void createUser(@RequestBody User user) throws ExceptionbySignUpValidation {
        new SignUpValidation().validate(user,userRepository);
        user.initialize(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
