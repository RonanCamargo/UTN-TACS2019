package utn.tacs.grupo3.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import utn.tacs.grupo3.retrofit.pojo.Json;


public interface GetDataService {

    @GET("v2/venues/search")
    Call<Json> getAllPlaces(
            @Query("client_id") String client_id,
            @Query("client_secret") String client_secret,
            @Query("v") String date,
            @Query("ll") String latitudeAndLongitude,
            @Query("limit") Integer limit);

}
