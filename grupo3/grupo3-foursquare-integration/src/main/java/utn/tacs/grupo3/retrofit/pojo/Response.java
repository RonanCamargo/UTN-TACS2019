package utn.tacs.grupo3.retrofit.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import utn.tacs.grupo3.model.Place;
import utn.tacs.grupo3.retrofit.pojo.Venue;

import java.util.List;

public class Response {
    @SerializedName("venues")
    @Expose
    public List<Place> venues = null;
    @SerializedName("confident")
    @Expose
    public Boolean confident;
}
