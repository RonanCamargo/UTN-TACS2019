package utn.tacs.grupo3.spring.service;

import utn.tacs.grupo3.model.User;

public interface UserService {
    void save(User user);
    void create(String username, String password);
    User findByUsername(String username);
}
