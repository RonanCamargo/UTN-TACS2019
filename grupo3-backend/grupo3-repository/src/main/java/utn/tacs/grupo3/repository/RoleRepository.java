package utn.tacs.grupo3.repository;

import org.springframework.stereotype.Repository;
import utn.tacs.grupo3.model.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RoleRepository {

    private List<Role> roles;

    public RoleRepository() {
        roles = new ArrayList<Role>();
        Role userRole = new Role("USER");
        Role adminRole = new Role("ADMIN");

        roles.add(userRole);
        roles.add(adminRole);
    }

    public Role getByName(String name) {
        return roles.stream().
                filter(role -> role.getName().equalsIgnoreCase(name)).
                collect(Collectors.toList()).get(0);
    }
}
