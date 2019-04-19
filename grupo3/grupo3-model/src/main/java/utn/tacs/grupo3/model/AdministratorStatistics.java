package utn.tacs.grupo3.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AdministratorStatistics {
    Calendar calendar = Calendar.getInstance();
    private List<User> registeredUsers;
    private List<Place> registeredPlaces;
    private Date currentDate;

    public AdministratorStatistics(Date currentDate) {
        registeredUsers = new ArrayList<>();
        registeredPlaces = new ArrayList<>();
        this.currentDate = currentDate;
        calendar.setTime(currentDate);
    }

    public void addUser(User user) {
        this.registeredUsers.add(user);
    }

    public long amountOfUsersInterestedIn(Place aPlace) {
        return registeredUsers.stream().filter(u -> (isTherePlaceInCommon(aPlace, u))).count();
    }

    private boolean isTherePlaceInCommon(Place aPlace, User u) {
        return u.getListOfPlaces().stream().anyMatch(listPlaces -> listPlaces.getFavouritePlaces().contains(aPlace));
    }

    public void addPlace(Place aPlace) {
        registeredPlaces.add(aPlace);
    }

    public long amountOfPlacesRegisteredInTheSystemToday() {
        return registeredPlaces.stream().filter(p -> (p.getRegistrationDate().equals(currentDate))).count();
    }

    public long amountOfPlacesRegisteredInTheSystemInTheLast(int days) {
        calendar.add(Calendar.DATE, -days);
        Date daysResults = calendar.getTime();
        return registeredPlaces.stream().filter(p -> (p.getRegistrationDate().after(daysResults))).count();
    }
}

