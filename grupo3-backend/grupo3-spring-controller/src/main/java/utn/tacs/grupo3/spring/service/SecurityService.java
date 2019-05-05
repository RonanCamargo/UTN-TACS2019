package utn.tacs.grupo3.spring.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
