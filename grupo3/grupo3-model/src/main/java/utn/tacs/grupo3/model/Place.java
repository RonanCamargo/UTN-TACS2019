package utn.tacs.grupo3.model;

public class Place {

    private String name;
    private String location;
	private String registrationDate;
	   
    
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

