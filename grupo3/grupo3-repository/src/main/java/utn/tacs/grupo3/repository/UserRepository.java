package utn.tacs.grupo3.repository;

import org.springframework.stereotype.Repository;
import utn.tacs.grupo3.model.ExceptionbyResourceNotFound;
import utn.tacs.grupo3.model.ListOfPlaces;
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
        User user1 = new User("Juan", "Perez");
        ListOfPlaces listOfPlaces1 = new ListOfPlaces("Lugares Favoritos");
        listOfPlaces1.addPlace(new Place("Casa", "Calle falsa 123"));
        user1.getListOfPlaces().add(listOfPlaces1);

        users.add(user1);
        users.add(new User("Elver", "Galarga"));
    }

    public List<User> allUsers() {
        return users;
    }

    public List<User> usersByFirstName(String nombre) {
        return users.stream().
                filter(user -> user.getFirstName().equalsIgnoreCase(nombre)).
                collect(Collectors.toList());
    }

    public User userByFirstName(String name) throws ExceptionbyResourceNotFound {
        return usersByFirstName(name)
                .stream().findFirst()
                .orElseThrow(() -> new ExceptionbyResourceNotFound("no se encontro al usuario"));
    }

    public void createUser(User user) {
        users.add(user);
    }

    public long amountOfUsersInterestedIn(Place aPlace) {
        return users.stream().filter(u -> u.havePlacesInCommonWith(aPlace)).count();
    }

    public List<ListOfPlaces> listsOfPlacesById(int id) throws ExceptionbyResourceNotFound {
        return users.stream()
                .map(user -> user.getListOfPlaces())
                .filter(listOfPlaces -> listOfPlaces.stream()
                        .anyMatch(lp -> lp.getId() == id)).
                        collect(Collectors.toList())
                .stream().findFirst()
                .orElseThrow(() -> new ExceptionbyResourceNotFound("no se encontro la lista de lugares con el id:" + id));
    }

    public ListOfPlaces listOfPlacesById(int id) throws ExceptionbyResourceNotFound {
        return listsOfPlacesById(id).get(0);
    }


}
