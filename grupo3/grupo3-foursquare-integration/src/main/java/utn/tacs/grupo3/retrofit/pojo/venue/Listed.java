
package utn.tacs.grupo3.retrofit.pojo.venue;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Listed {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("groups")
    @Expose
    private List<Group_____> groups = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Group_____> getGroups() {
        return groups;
    }

    public void setGroups(List<Group_____> groups) {
        this.groups = groups;
    }

}
