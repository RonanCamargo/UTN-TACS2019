package utn.tacs.grupo3.model;

import java.time.LocalDate;

public class Place {

    private String name;
    private String address;
    @Deprecated
	private LocalDate registrationDate;
	private Float latitude;
	private Float longitude;
	private String foursquareId;
	private Boolean visited;


	public Place() {}

    public Place(String name, String address) {
        this.name = name;
        this.address = address;
        this.registrationDate = LocalDate.now();
    }

	public String getName() {
		return name;
	}

	@Deprecated
	public boolean wasRegisteredInTheDays(LocalDate lastDays, LocalDate currentDate) {
		return registrationDate.isAfter(lastDays) || registrationDate.equals(currentDate);
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

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
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

