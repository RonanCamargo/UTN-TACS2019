package utn.tacs.grupo3.repository.administrator;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import utn.tacs.grupo3.model.Place;
import utn.tacs.grupo3.repository.PlaceRepository;

public class PlacesRegisteredInTheSystemTest {

    private PlaceRepository placeRepository;

    @Before
    public void initialize() {
        placeRepository = new PlaceRepository();
        Place place1 = placeRepository.createPlace("place1");
        Place place2 = placeRepository.createPlace("place2");
        Place place3 = placeRepository.createPlace("place3");
        Place place4 = placeRepository.createPlace("place4");

        LocalDate today = LocalDate.of(2019, Month.APRIL, 19);

        place1.setRegistrationDate(today);
        place2.setRegistrationDate(LocalDate.of(2019, Month.APRIL, 16));
        place3.setRegistrationDate(LocalDate.of(2019, Month.MARCH, 30));
        place4.setRegistrationDate(LocalDate.of(2006, Month.APRIL, 19));

        placeRepository.setCurrentDate(today);

    }

    //15-Como administrador quiero conocer la cantidad total de lugares
//    registrados en el sistema:
//    En el día de hoy
    @Test
    public void knowTheTotalNumberOfPlacesRegisteredInTheSystemToday() {
        Assert.assertEquals(1, placeRepository.amountOfPlacesRegisteredInTheSystemToday());

    }

    //    En los últimos 3 días
    @Test
    public void knowTheTotalNumberOfPlacesRegisteredInTheSystemInTheLast3Days() {
        Assert.assertEquals(1, placeRepository.amountOfPlacesRegisteredInTheSystemInTheLast(3));
    }

    //    En la última semana
    @Test
    public void knowTheTotalNumberOfPlacesRegisteredInTheSystemInTheLastWeek() {
        Assert.assertEquals(2, placeRepository.amountOfPlacesRegisteredInTheSystemInTheLast(7));
    }

    //    En el último mes
    @Test
    public void knowTheTotalNumberOfPlacesRegisteredInTheSystemInTheLastMonth() {
        Assert.assertEquals(3, placeRepository.amountOfPlacesRegisteredInTheSystemInTheLast(30));
    }

    //    Desde el inicio de los tiempos
    @Test
    public void knowTheTotalNumberOfPlacesRegisteredInTheSystemInTheLastMonthSinceTheBeginningOfTime() {
        Assert.assertEquals(4, placeRepository.amountOfPlacesRegisteredInTheSystemInTheLast(Integer.MAX_VALUE));

    }
}

