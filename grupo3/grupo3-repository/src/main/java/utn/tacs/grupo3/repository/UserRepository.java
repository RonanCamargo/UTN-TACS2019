package utn.tacs.grupo3.repository;

import org.springframework.stereotype.Repository;
import utn.tacs.grupo3.model.ExceptionbyResourceNotFound;
import utn.tacs.grupo3.model.ListOfPlaces;
import utn.tacs.grupo3.model.Place;
import utn.tacs.grupo3.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class UserRepository {

    private List<User> users;

    public UserRepository() {
        users = new ArrayList<User>();
        User user1 = new User("Juan", "Perez");
        ListOfPlaces listOfPlaces1 = new ListOfPlaces("Lugares Favoritos");
        listOfPlaces1.addPlace(new Place("Casa", "Calle falsa 123"));
        user1.getListsOfPlaces().add(listOfPlaces1);
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

    public Stream<List<ListOfPlaces>> listsOfPlacesById(int id) {
        return users.stream()
                .map(user -> user.getListsOfPlaces())
                .filter(listsOfPlaces ->
                        listsOfPlaces.stream().anyMatch(lp -> lp.getId() == id));
    }

    private List<ListOfPlaces> searchForListsOfPlacesBy(int id) throws ExceptionbyResourceNotFound {
        return listsOfPlacesById(id).findFirst().
                orElseThrow(() -> new ExceptionbyResourceNotFound("no se encontro la lista de lugares con el id:" + id));
    }

    public ListOfPlaces listOfPlacesById(int id) throws ExceptionbyResourceNotFound {
        return searchForListsOfPlacesBy(id).get(0);

    }
}
