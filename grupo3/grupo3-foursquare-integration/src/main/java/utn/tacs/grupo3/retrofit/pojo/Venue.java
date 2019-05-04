package utn.tacs.grupo3.retrofit.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Venue {
        @SerializedName("id")
        @Expose
        public String id;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("location")
        @Expose
        private Location location;


        public String getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public Location getLocation() {
                return location;
        }

}
