package utn.tacs.grupo3.retrofit.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {
    @SerializedName("code")
    @Expose
    public Integer code;
    @SerializedName("requestId")
    @Expose
    public String requestId;
}
