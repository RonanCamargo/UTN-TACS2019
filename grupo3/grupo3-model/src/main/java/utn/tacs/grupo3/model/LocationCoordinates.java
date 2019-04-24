package utn.tacs.grupo3.model;

public class LocationCoordinates {
    private String latitude;
    private String longitude;
    
	public LocationCoordinates(String latitude, String longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}
	
	
}
