package utn.tacs.grupo3.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Place {
	@SerializedName("name")
	@Expose
    private String name;
	@SerializedName("id")
	@Expose
    private String location;
	   
    
    public Place(String name, String location) {
		this.name = name;
		this.location = location;
	}
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
    
    

}

