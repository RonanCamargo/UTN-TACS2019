package utn.tacs.grupo3.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import utn.tacs.grupo3.model.Place;

@Repository
public class PlaceRepository {

    private List<Place> places;
    private LocalDate currentDate;

    public PlaceRepository() {
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

    public Place findPlaceOrCreateIt(String placeId) {
        if (placesByName(placeId).isEmpty()) {
            Place place = new Place(placeId, "");
            createPlace(place);
        }
        return placesByName(placeId).get(0);
    }

    public long amountOfPlacesRegisteredInTheSystemToday() {
        return places.stream()
                .filter(p -> p.getRegistrationDate().equals(currentDate))
                .count();
    }

    public long amountOfPlacesRegisteredInTheSystemInTheLast(int days) {
        LocalDate lastDays = currentDate.minusDays(days);

        return places.stream()
                .filter(p -> p.getRegistrationDate().isAfter(lastDays))
                .count();
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }
}
