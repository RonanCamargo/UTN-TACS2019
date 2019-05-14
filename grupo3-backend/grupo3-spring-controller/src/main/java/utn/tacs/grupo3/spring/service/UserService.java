package utn.tacs.grupo3.spring.service;

import utn.tacs.grupo3.model.User;

public interface UserService {
    User save(User user);
    User create(User user);
    User findByUsername(String username);
}
