package utn.tacs.grupo3.model.pojoFoursquare;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Json {
    @SerializedName("meta")
    @Expose
    public Meta meta;
    @SerializedName("response")
    @Expose
    public Response response;
}
