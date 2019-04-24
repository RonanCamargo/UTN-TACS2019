package utn.tacs.grupo3.retrofit;

import retrofit2.Call;
import retrofit2.Response;
import utn.tacs.grupo3.retrofit.pojo.Pojo;
import utn.tacs.grupo3.retrofit.pojo.Venue;

import java.io.IOException;
import java.util.List;

public class ForsquarePlacesRequest {

    private final String CLIENT_ID = "0CIZ4KNH3ALVF0GUOZ12A143LUYBUFLGDKF1GBNFF0G0JSSR";
    private final String CLIENT_SECRET = "BEK4JRCQKDEIZJB3GUBLE3SUNY33WXNRQ5EWBNJFOTOYSHN5";
    private final String DATE = "20180703";

    public List<Venue> getAllPlaces(String latitudeAndLongitude) {

        ForsquareService service = RetrofitClientInstance.getRetrofitInstance().create(ForsquareService.class);
        Call<Pojo> call = service.getAllPlaces(CLIENT_ID, CLIENT_SECRET, DATE, latitudeAndLongitude, 5);
        try {
            Response<Pojo> response = call.execute();
            return response.body().response.venues;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


}
