package utn.tacs.grupo3.retrofit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utn.tacs.grupo3.retrofit.pojo.Venue;

import java.util.List;

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
}
