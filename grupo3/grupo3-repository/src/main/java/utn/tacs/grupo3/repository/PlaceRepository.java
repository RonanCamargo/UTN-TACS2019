package utn.tacs.grupo3.repository;

import org.springframework.stereotype.Repository;
import utn.tacs.grupo3.model.Place;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PlaceRepository {

    private List<Place> places;
    private Date currentDate;
    private Calendar calendar = Calendar.getInstance();


    public PlaceRepository(Date currentDate) {
        this.currentDate = currentDate;
        places = new ArrayList<Place>();
    }

    public List<Place> allPlaces() {
        return places;
    }

    public List<Place> placesByName(String name) {
        return places.stream().
                filter(lugar -> lugar.getName().equalsIgnoreCase(name)).
                collect(Collectors.toList());
    }

    public void createPlace(Place place) {
        places.add(place);
    }

    public long amountOfPlacesRegisteredInTheSystemToday() {
        return places.stream().filter(p -> (p.getRegistrationDate().equals(currentDate))).count();
    }

    public long amountOfPlacesRegisteredInTheSystemInTheLast(int days) {
        calendar.add(Calendar.DATE, -days);
        Date daysResults = calendar.getTime();
        return places.stream().filter(p -> (p.getRegistrationDate().after(daysResults))).count();
    }

}
