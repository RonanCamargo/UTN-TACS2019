package utn.tacs.grupo3.spring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import utn.tacs.grupo3.model.RegisteredPlace;
import utn.tacs.grupo3.model.exception.ExceptionbyResourceNotFound;
import utn.tacs.grupo3.retrofit.pojo.Venue;

/**
 * Interface for place-related controller methods
 */
public interface PlaceController {

    /**
     * Returns all registered places
     *
     * @return a list of places
     */
    List<RegisteredPlace> places();

    /**
     * Searches a place by its id
     *
     * @param placeId
     * @return
     */
    RegisteredPlace placeById(String placeId) throws ExceptionbyResourceNotFound;

    /**
     * Searches near places based on coordinates
     *
     * @param coordinates
     * @return
     */
    List<Venue> near(String coordinates);

    @GetMapping("/near-by-name")
    List<Venue> nearByName(@RequestParam("name") String name);
}