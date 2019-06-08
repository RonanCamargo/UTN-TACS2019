package utn.tacs.grupo3.model;

public class Place {

    private String name;
    private String address;
	private Float latitude;
	private Float longitude;
	private String foursquareId;
	private Boolean visited;


	public Place() {}

    public Place(String name, String address) {
        this.name = name;
        this.address = address;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Float getLatitude() {
		return latitude;
	}
	
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	
	public Float getLongitude() {
		return longitude;
	}
	
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	
	public String getFoursquareId() {
		return foursquareId;
	}
	
	public void setFoursquareId(String foursquareId) {
		this.foursquareId = foursquareId;
	}

	public Boolean getVisited() {
		return visited;
	}

	public void setVisited(Boolean visited) {
		this.visited = visited;
	}
}

