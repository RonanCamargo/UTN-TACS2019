package utn.tacs.grupo3.model;

import java.util.ArrayList;
import java.util.List;

public class Administrator {

    private List<User> users;
    private List<Place> registeredPlaces;

    public Administrator() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public long amountOfUsersInterestedIn(Place aPlace) {
        return users.stream().filter(u->(isTherePlaceInCommon(aPlace,u)) ).count();
    }

    private boolean isTherePlaceInCommon(Place aPlace, User u) {
        return u.getListOfPlaces().stream().anyMatch(listPlaces->listPlaces.getFavouritePlaces().contains(aPlace));
    }
}

