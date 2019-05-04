package utn.tacs.grupo3.retrofit.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {
    @SerializedName("address")
    @Expose
    public String address;
    @SerializedName("lat")
    @Expose
    public Double latitude;
    @SerializedName("lng")
    @Expose
    public Double longitude;

    public String getAddress() {
        return address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
