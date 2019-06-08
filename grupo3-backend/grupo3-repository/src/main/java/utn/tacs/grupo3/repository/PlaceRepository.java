package utn.tacs.grupo3.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import utn.tacs.grupo3.model.Place;
import utn.tacs.grupo3.model.exception.ExceptionbyPlaceNotFound;
import utn.tacs.grupo3.model.exception.ExceptionbyResourceNotFound;

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

    @Deprecated
    public Place createPlace(String placeId) {
        if (placesByName(placeId).isEmpty()) {
            Place place = new Place(placeId, "");
            places.add(place);
        }
        return placesByName(placeId).get(0);
    }
    
    @Deprecated
    public Place createPlace(Place place) {
        if (placesByName(place.getName()).isEmpty()) {
            places.add(place);
        }
        return placesByName(place.getName()).get(0);
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

}
