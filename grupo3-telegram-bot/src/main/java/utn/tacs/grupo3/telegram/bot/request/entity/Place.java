
package utn.tacs.grupo3.telegram.bot.request.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "location", "registrationDate" })
public class Place {

	@JsonProperty("name")
	private String name;
	@JsonProperty("location")
	private String location;
	@JsonProperty("registrationDate")
	private String registrationDate;

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("location")
	public String getLocation() {
		return location;
	}

	@JsonProperty("location")
	public void setLocation(String location) {
		this.location = location;
	}

	@JsonProperty("registrationDate")
	public String getRegistrationDate() {
		return registrationDate;
	}

	@JsonProperty("registrationDate")
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

}
