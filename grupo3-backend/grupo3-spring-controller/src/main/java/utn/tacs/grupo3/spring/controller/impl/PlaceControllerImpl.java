package utn.tacs.grupo3.spring.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import utn.tacs.grupo3.model.RegisteredPlace;
import utn.tacs.grupo3.model.exception.ExceptionbyResourceNotFound;
import utn.tacs.grupo3.retrofit.pojo.Venue;
import utn.tacs.grupo3.service.PlaceService;
import utn.tacs.grupo3.spring.controller.PlaceController;

@RestController
@RequestMapping("/places")
public class PlaceControllerImpl implements PlaceController {

	@Autowired
	private PlaceService placeService;

    @GetMapping
    public List<RegisteredPlace> places() {
        return placeService.allRegisteredPlaces();
    }

    @Override
    @GetMapping("/{place-id}")
    public RegisteredPlace placeById(@PathVariable("place-id") String placeId) throws ExceptionbyResourceNotFound {
        return placeService.findById(placeId);
    }

    @Override
    @GetMapping("/near")
    public List<Venue> near(@RequestParam("coordinates") String coordinates) {
        return placeService.venuesNearByCoordinates(coordinates);
    }

    @Override
    @GetMapping("/near-by-name")
    public List<Venue> nearByName(@RequestParam("name") String name) {
        return placeService.venuesNearByName(name);
    }

}
