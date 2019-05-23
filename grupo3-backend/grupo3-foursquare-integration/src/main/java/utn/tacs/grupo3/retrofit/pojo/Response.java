package utn.tacs.grupo3.retrofit.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {
    @SerializedName("venues")
    @Expose
    public List<Venue> venues = null;
    @SerializedName("confident")
    @Expose
    public Boolean confident;
}
