
package utn.tacs.grupo3.retrofit.pojo.venue;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Timeframe_ {

    @SerializedName("days")
    @Expose
    private String days;
    @SerializedName("open")
    @Expose
    private List<Open_> open = null;
    @SerializedName("segments")
    @Expose
    private List<Object> segments = null;

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public List<Open_> getOpen() {
        return open;
    }

    public void setOpen(List<Open_> open) {
        this.open = open;
    }

    public List<Object> getSegments() {
        return segments;
    }

    public void setSegments(List<Object> segments) {
        this.segments = segments;
    }

}
