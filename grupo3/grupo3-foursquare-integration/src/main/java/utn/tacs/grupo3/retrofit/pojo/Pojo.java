package utn.tacs.grupo3.retrofit.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pojo {
    @SerializedName("meta")
    @Expose
    public Meta meta;
    @SerializedName("response")
    @Expose
    public Response response;
}
