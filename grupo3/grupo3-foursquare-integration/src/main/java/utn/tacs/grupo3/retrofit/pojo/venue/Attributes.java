
package utn.tacs.grupo3.retrofit.pojo.venue;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attributes {

    @SerializedName("groups")
    @Expose
    private List<Group______> groups = null;

    public List<Group______> getGroups() {
        return groups;
    }

    public void setGroups(List<Group______> groups) {
        this.groups = groups;
    }

}
