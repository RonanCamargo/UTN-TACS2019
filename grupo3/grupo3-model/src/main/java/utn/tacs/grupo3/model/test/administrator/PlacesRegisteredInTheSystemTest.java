package utn.tacs.grupo3.model.test.administrator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utn.tacs.grupo3.model.AdministratorStatistics;
import utn.tacs.grupo3.model.Place;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlacesRegisteredInTheSystemTest {

    private AdministratorStatistics administratorStatistics;

    @Before
    public void initialize() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date today = null;
        Date date2 = null;
        Date date3 = null;
        Date date4 = null;
        try {
            today = sdf.parse("2019-04-19");
            date2 = sdf.parse("2019-04-16");
            date3 = sdf.parse("2019-03-30");
            date4 = sdf.parse("2006-04-19");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Place place1 = new Place("", "");
        Place place2 = new Place("", "");
        Place place3 = new Place("", "");
        Place place4 = new Place("", "");

        place1.setRegistrationDate(today);
        place2.setRegistrationDate(date2);
        place3.setRegistrationDate(date3);
        place4.setRegistrationDate(date4);

        administratorStatistics = new AdministratorStatistics(today);
        administratorStatistics.addPlace(place1);
        administratorStatistics.addPlace(place2);
        administratorStatistics.addPlace(place3);
        administratorStatistics.addPlace(place4);
    }

    //15-Como administrador quiero conocer la cantidad total de lugares
//    registrados en el sistema:
//    En el día de hoy
    @Test
    public void knowTheTotalNumberOfPlacesRegisteredInTheSystemToday() {
        Assert.assertEquals(1, administratorStatistics.amountOfPlacesRegisteredInTheSystemToday());

    }

    //    En los últimos 3 días
    @Test
    public void knowTheTotalNumberOfPlacesRegisteredInTheSystemInTheLast3Days() {
        Assert.assertEquals(1, administratorStatistics.amountOfPlacesRegisteredInTheSystemInTheLast(3));

    }

    //    En la última semana
    @Test
    public void knowTheTotalNumberOfPlacesRegisteredInTheSystemInTheLastWeek() {
        Assert.assertEquals(2, administratorStatistics.amountOfPlacesRegisteredInTheSystemInTheLast(7));
    }

    //    En el último mes
    @Test
    public void knowTheTotalNumberOfPlacesRegisteredInTheSystemInTheLastMonth() {
        Assert.assertEquals(3, administratorStatistics.amountOfPlacesRegisteredInTheSystemInTheLast(30));
    }

    //    Desde el inicio de los tiempos
    @Test
    public void knowTheTotalNumberOfPlacesRegisteredInTheSystemInTheLastMonthSinceTheBeginningOfTime() {
        Assert.assertEquals(4, administratorStatistics.amountOfPlacesRegisteredInTheSystemInTheLast(Integer.MAX_VALUE));

    }
}

