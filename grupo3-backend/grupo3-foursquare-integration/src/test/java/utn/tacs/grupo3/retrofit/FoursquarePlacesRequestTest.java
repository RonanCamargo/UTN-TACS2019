package utn.tacs.grupo3.retrofit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import utn.tacs.grupo3.retrofit.pojo.venue.FullVenue;

public class FoursquarePlacesRequestTest {

    private FoursquarePlacesRequest foursquarePlacesRequest;

    @Before
    public void initialize() {
        foursquarePlacesRequest = new FoursquarePlacesRequest();
    }

    @Test
    public void searchOfCongresoDeLaNaciónArgentinaByCartesianCoordinates() {
        Assert.assertEquals(5, foursquarePlacesRequest.getAllPlacesByCoordinates("-34.6093499,-58.3928535").size());
    }

    @Test
    public void searchForPlacesByName() {
        Assert.assertEquals(5, foursquarePlacesRequest.getAllPlacesByName("utn").size());
    }
    
    @Test
    public void searchUTNCampusByFoursquareId() {
    	FullVenue fullVenue = foursquarePlacesRequest.getVenueById("4b850a3bf964a520934931e3");
    	Assert.assertEquals("UTN FRBA (Sede Campus)", fullVenue.getName());
    }
}
