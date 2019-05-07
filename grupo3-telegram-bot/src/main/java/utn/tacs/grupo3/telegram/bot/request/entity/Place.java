
package utn.tacs.grupo3.telegram.bot.request.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "address", "registrationDate", "latitude", "longitude", "foursquareId" })
public class Place {

	@JsonProperty("name")
	private String name;
	@JsonProperty("address")
	private String address;
	@JsonProperty("registrationDate")
	private String registrationDate;
	@JsonProperty("latitude")
	private Double latitude;
	@JsonProperty("longitude")
	private Double longitude;
	@JsonProperty("foursquareId")
	private Object foursquareId;

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("address")
	public String getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(String address) {
		this.address = address;
	}

	@JsonProperty("registrationDate")
	public String getRegistrationDate() {
		return registrationDate;
	}

	@JsonProperty("registrationDate")
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	@JsonProperty("latitude")
	public Double getLatitude() {
		return latitude;
	}

	@JsonProperty("latitude")
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	@JsonProperty("longitude")
	public Double getLongitude() {
		return longitude;
	}

	@JsonProperty("longitude")
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@JsonProperty("foursquareId")
	public Object getFoursquareId() {
		return foursquareId;
	}

	@JsonProperty("foursquareId")
	public void setFoursquareId(Object foursquareId) {
		this.foursquareId = foursquareId;
	}

}