package utn.tacs.grupo3.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import utn.tacs.grupo3.model.User;
import utn.tacs.grupo3.model.exception.ExceptionbyResourceNotFound;
import utn.tacs.grupo3.repository.RoleRepository;
import utn.tacs.grupo3.repository.UserRepository;
import utn.tacs.grupo3.spring.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.addRole(roleRepository.getByName("USER"));
        userRepository.createUser(user);
    }
    @Override
    public void create(String username, String password) {
        save(new User(username, password));
    }

    @Override
    public User findByUsername(String username) throws UsernameNotFoundException {
        try {
            return userRepository.userByUsername(username);
        }
        catch( ExceptionbyResourceNotFound ex) {
            throw new UsernameNotFoundException(username);
        }
    }
}
