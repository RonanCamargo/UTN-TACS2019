package utn.tacs.grupo3.retrofit;

import utn.tacs.grupo3.model.Place;

import java.util.List;

public interface ForsquarePlacesCallback {
    void onSuccess(List<Place> places);
    void onError(String message);
}
