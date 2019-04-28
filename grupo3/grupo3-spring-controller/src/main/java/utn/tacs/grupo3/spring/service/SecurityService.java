package utn.tacs.grupo3.spring.service;

public interface SecurityService {
    String findLoggedInUsername();

    void login(String username, String password);
}
