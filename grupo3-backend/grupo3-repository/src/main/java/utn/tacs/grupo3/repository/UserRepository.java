package utn.tacs.grupo3.repository;

import org.springframework.stereotype.Repository;
import utn.tacs.grupo3.model.exception.ExceptionbyListOfPlaceNotFound;
import utn.tacs.grupo3.model.exception.ExceptionbyResourceNotFound;
import utn.tacs.grupo3.model.ListOfPlaces;
import utn.tacs.grupo3.model.Place;
import utn.tacs.grupo3.model.User;
import utn.tacs.grupo3.model.exception.ExceptionbyUserNotFound;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class UserRepository {

    private List<User> users;

    public UserRepository() {
        users = new ArrayList<User>();
        User user1 = new User("Juan", "Perez","JPerez1","123","ADMIN");
        ListOfPlaces listOfPlaces1 = new ListOfPlaces("LugaresFavoritos");
        Place casa = new Place("Casa", "Calle falsa 123");
        casa.setLatitude(-34.659581f);
        casa.setLongitude(-58.468068f);

        listOfPlaces1.addPlace(casa);
        user1.getListsOfPlaces().add(listOfPlaces1);
        users.add(user1);
    }

    public List<User> allUsers() {
        return users;
    }

    public List<User> usersByUsername(String name) {
        return users.stream().
                filter(user -> user.getUsername().equalsIgnoreCase(name)).
                collect(Collectors.toList());
    }

    public User userByUsername(String name) throws ExceptionbyResourceNotFound {
        return usersByUsername(name)
                .stream().findFirst()
                .orElseThrow(() -> new ExceptionbyUserNotFound(name));
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
                orElseThrow(() -> new ExceptionbyListOfPlaceNotFound(""+id));
    }

    public ListOfPlaces listOfPlacesById(int id) throws ExceptionbyResourceNotFound {
        return searchForListsOfPlacesBy(id).get(0);

    }
}
