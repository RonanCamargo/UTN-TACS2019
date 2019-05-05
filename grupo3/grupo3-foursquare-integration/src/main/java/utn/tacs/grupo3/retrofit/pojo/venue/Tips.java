
package utn.tacs.grupo3.retrofit.pojo.venue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tips {

    @SerializedName("count")
    @Expose
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
