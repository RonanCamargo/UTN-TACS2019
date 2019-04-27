package utn.tacs.grupo3.model;

import java.time.LocalDate;

public class Place {

    private String name;
    private String location;
	private LocalDate registrationDate;

	public Place() {}
	
    public Place(String name, String location) {
        this.name = name;
        this.location = location;
        this.registrationDate = LocalDate.now();
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

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
    
}

