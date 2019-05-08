package utn.tacs.grupo3.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import utn.tacs.grupo3.retrofit.pojo.Pojo;
import utn.tacs.grupo3.retrofit.pojo.venue.VenuePojo;


public interface FoursquareService {

    @GET("v2/venues/search")
    Call<Pojo> getAllPlacesByCoordinates(
            @Query("client_id") String client_id,
            @Query("client_secret") String client_secret,
            @Query("v") String date,
            @Query("ll") String latitudeAndLongitude,
            @Query("limit") Integer limit);

    @GET("v2/venues/search")
    Call<Pojo> getAllPlacesByName(
            @Query("client_id") String client_id,
            @Query("client_secret") String client_secret,
            @Query("v") String date,
            @Query("limit") Integer limit,
            @Query("query") String query,
            @Query("near") String near);
    
    @GET("v2/venues/{venue-id}")
    Call<VenuePojo> getVenue(
    		@Path("venue-id") String venueId,
    		@Query("client_id") String client_id,
            @Query("client_secret") String client_secret,
            @Query("v") String date);
}


