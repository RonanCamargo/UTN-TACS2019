package utn.tacs.grupo3.spring.controller;

import org.springframework.web.bind.annotation.RequestBody;
import utn.tacs.grupo3.model.Login;
import utn.tacs.grupo3.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Interface for login-related controller methods
 */
public interface LoginController {
    void register(User user);
    void login(Login login);
}