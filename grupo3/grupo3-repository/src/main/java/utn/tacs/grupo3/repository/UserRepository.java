package utn.tacs.grupo3.repository;

import org.springframework.stereotype.Repository;
import utn.tacs.grupo3.model.Place;
import utn.tacs.grupo3.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository {

    private List<User> users;

    public UserRepository() {
        users = new ArrayList<User>();
        users.add(new User("Juan", "Perez", null, "s"));
        users.add(new User("Elver", "Galarga", null, "s"));
    }

    public List<User> allUsers() {
        return users;
    }

    public List<User> usersByFirstName(String nombre) {
        return users.stream().
                filter(user -> user.getFirstName().equalsIgnoreCase(nombre)).
                collect(Collectors.toList());
    }

    public void createUser(User user) {
        users.add(user);
    }

    public long amountOfUsersInterestedIn(Place aPlace) {
        return users.stream().filter(u -> u.havePlacesInCommonWith(aPlace)).count();
    }

}
