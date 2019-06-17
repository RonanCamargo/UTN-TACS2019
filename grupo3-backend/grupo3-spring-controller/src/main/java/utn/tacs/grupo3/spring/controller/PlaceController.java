package utn.tacs.grupo3.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import utn.tacs.grupo3.spring.controller.response.Response;

/**
 * Interface for place-related controller methods
 */
public interface PlaceController {

    /**
     * Returns all registered places
     *
     * @return a list of places
     */
    Response places();

    /**
     * Searches a place by its id
     *
     * @param placeId
     * @return
     */
    Response placeById(String placeId);

    /**
     * Searches near places based on coordinates
     *
     * @param coordinates
     * @return
     */
    Response near(String coordinates);

    @GetMapping("/near-by-name")
    Response nearByName(@RequestParam("name") String name);
}