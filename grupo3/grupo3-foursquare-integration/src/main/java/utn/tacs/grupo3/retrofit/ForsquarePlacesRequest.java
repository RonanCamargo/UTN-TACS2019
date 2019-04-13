package utn.tacs.grupo3.retrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utn.tacs.grupo3.retrofit.pojo.Pojo;

public class ForsquarePlacesRequest {

    public ForsquarePlacesRequest(ForsquarePlacesCallback callback) {
        this.callback = callback;
    }

    private ForsquarePlacesCallback callback;

    private final String CLIENT_ID = "0CIZ4KNH3ALVF0GUOZ12A143LUYBUFLGDKF1GBNFF0G0JSSR";
    private final String CLIENT_SECRET = "BEK4JRCQKDEIZJB3GUBLE3SUNY33WXNRQ5EWBNJFOTOYSHN5";
    private final String DATE = "20180703";

    public void getAllPlaces() {

        ForsquareService service = RetrofitClientInstance.getRetrofitInstance().create(ForsquareService.class);
        Call<Pojo> call = service.getAllPlaces(CLIENT_ID, CLIENT_SECRET, DATE, "-34.598599800,-58.419921700", 5);
        call.enqueue(new Callback<Pojo>() {
            @Override
            public void onResponse(Call<Pojo> call, Response<Pojo> response) {
                callback.onSuccess(response.body().response.venues);
            }

            @Override
            public void onFailure(Call<Pojo> call, Throwable t) {
                callback.onError("dsds");

            }
        });

    }


}
