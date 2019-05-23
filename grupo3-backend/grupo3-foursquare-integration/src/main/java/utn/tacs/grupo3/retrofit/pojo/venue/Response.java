
package utn.tacs.grupo3.retrofit.pojo.venue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("venue")
    @Expose
    private FullVenue venue;

    public FullVenue getVenue() {
        return venue;
    }

    public void setVenue(FullVenue venue) {
        this.venue = venue;
    }

}
