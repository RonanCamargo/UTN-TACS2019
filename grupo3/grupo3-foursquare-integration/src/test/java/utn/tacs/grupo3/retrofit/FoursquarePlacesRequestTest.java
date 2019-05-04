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
    public void searchOfUTNByCartesianCoordinates() {
        List<Venue> list = foursquarePlacesRequest.getAllPlaces("-34.598599800,-58.419921700");
        list.get(0);
        Assert.assertEquals(5, foursquarePlacesRequest.getAllPlaces("-34.598599800,-58.419921700").size());
    }

    @Test
    public void searchOfAnsesByCartesianCoordinates() {
        List<Venue> list = foursquarePlacesRequest.getAllPlaces("-34.598599800,-58.419921700");
        list.get(0);
        Assert.assertEquals(5, foursquarePlacesRequest.getAllPlaces("-34.61315,-58.37723").size());
    }

    @Test
    public void searchOfCongresoDeLaNaciónArgentinaByCartesianCoordinates() {

        Assert.assertEquals(5, foursquarePlacesRequest.getAllPlaces("-34.6093499,-58.3928535").size());
    }
}
