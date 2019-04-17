package utn.tacs.grupo3.retrofit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ForsquarePlacesRequestTest {

    private ForsquarePlacesRequest forsquarePlacesRequest;

    @Before
    public void initialize() {
        forsquarePlacesRequest=new ForsquarePlacesRequest();
    }

    @Test
    public void searchOfUTNByCartesianCoordinates() {
        Assert.assertEquals("UTN.BA - Extensión Universitaria",forsquarePlacesRequest.getAllPlaces("-34.598599800,-58.419921700").get(0).getName());
    }

    @Test
    public void searchOfAnsesByCartesianCoordinates() {
        Assert.assertEquals("Anses",forsquarePlacesRequest.getAllPlaces("-34.61315,-58.37723").get(1).getName());
    }

    @Test
    public void searchOfCongresoDeLaNaciónArgentinaByCartesianCoordinates() {
        Assert.assertEquals("Palacio del Congreso de la Nación Argentina",forsquarePlacesRequest.getAllPlaces("-34.6093499,-58.3928535").get(0).getName());
    }
}
