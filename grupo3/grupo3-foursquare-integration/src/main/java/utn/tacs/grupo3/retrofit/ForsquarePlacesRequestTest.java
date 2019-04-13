package utn.tacs.grupo3.retrofit;

import org.junit.jupiter.api.Test;
import utn.tacs.grupo3.model.Place;

import java.util.List;

public class ForsquarePlacesRequestTest implements ForsquarePlacesCallback {

    @Test
    public void requestTest() {
        ForsquarePlacesRequest forsquarePlacesRequest=new ForsquarePlacesRequest(this);
        forsquarePlacesRequest.getAllPlaces();
    }

    @Override
    public void onSuccess(List<Place> places) {
        places.get(1);
    }

    @Override
    public void onError(String message) {

    }
}
