package utn.tacs.grupo3.model;

import java.util.Calendar;
import java.util.Date;

public class Place {

    private String name;
    private String location;
    private Date registrationDate;


    public Place(String name, String location) {
        this.name = name;
        this.location = location;
        setRegistrationDate(Calendar.getInstance().getTime());
    }

    public String getName() {
        return name;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}

