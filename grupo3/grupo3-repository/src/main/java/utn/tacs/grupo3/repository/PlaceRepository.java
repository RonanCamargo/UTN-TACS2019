package utn.tacs.grupo3.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import utn.tacs.grupo3.model.exception.ExceptionbyPlaceNotFound;
import utn.tacs.grupo3.model.exception.ExceptionbyResourceNotFound;
import utn.tacs.grupo3.model.Place;

@Repository
public class PlaceRepository {

    private List<Place> places;
    private LocalDate currentDate;

    public PlaceRepository() {
        places = new ArrayList<>();
    }

    public List<Place> allPlaces() {
        return places;
    }

    public List<Place> placesByName(String name) {
        return places.stream().
                filter(place -> place.getName().equalsIgnoreCase(name)).
                collect(Collectors.toList());
    }

    public Place placeByName(String placeId) throws ExceptionbyResourceNotFound {
        return placesByName(placeId)
                .stream().findFirst()
                .orElseThrow(() -> new ExceptionbyPlaceNotFound(placeId));
    }

    public Place createPlace(String placeId) {
        if (placesByName(placeId).isEmpty()) {
            Place place = new Place(placeId, "");
            places.add(place);
        }
        return placesByName(placeId).get(0);
    }

    public long amountOfPlacesRegisteredInTheSystemInTheLast(int days) {
        LocalDate lastDays = currentDate.minusDays(days);

        return places.stream()
                .filter(place -> place.wasRegisteredInTheDays(lastDays,currentDate))
                .count();
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

}
