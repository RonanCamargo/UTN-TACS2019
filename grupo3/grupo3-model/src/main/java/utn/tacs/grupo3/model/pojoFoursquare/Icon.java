package utn.tacs.grupo3.model.pojoFoursquare;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Icon {
    @SerializedName("prefix")
    @Expose
    public String prefix;
    @SerializedName("suffix")
    @Expose
    public String suffix;
}
