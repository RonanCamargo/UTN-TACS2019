package utn.tacs.grupo3.model.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utn.tacs.grupo3.model.ListOfPlaces;
import utn.tacs.grupo3.model.Place;
import utn.tacs.grupo3.model.User;

public class ABMofPlacesTest {
    private User user1;
    private ListOfPlaces listOfPlaces1;
    private Place aPlace1;

    @Before
    public void initialize() {
        user1 = new User("Elver", "Galarga",null,null,null,2,3,"s");
        listOfPlaces1 = new ListOfPlaces("Lugares Favoritos");
        user1.getListOfPlaces().add(listOfPlaces1);
        aPlace1 = new Place("el MC","en algun lado");
    }


    //6-Como usuario quiero poder registrar un lugar que me interesa en una de mis listas de lugares.
    @Test
    public void registerAPlaceinAListOfFavouritePlaces(){
        Place place1= new Place("mundo fantastico","calle falsa 123");
        listOfPlaces1.addPlace(place1);
        Assert.assertEquals(1, listOfPlaces1.getFavouritePlaces().size());
    }

    //7-Como usuario quiero crear, eliminar o cambiar el nombre a las diferentes listas de lugares que poseo.
    @Test
    public void createListOfPlaces(){
        user1.createListOfPlaces("Lugares Fantasticos");
        Assert.assertEquals("Lugares Fantasticos", user1.getListOfPlaces().get(1).getListName() );
    }

    @Test
    public void removeListOfPlaces(){
        user1.removeFromListsOfPlaces(listOfPlaces1);
        Assert.assertEquals(0, user1.getListOfPlaces().size() );
    }

    @Test
    public void changeNameOfAPlacesList(){
        listOfPlaces1.setListName("cambio de nombre");
        Assert.assertEquals("cambio de nombre",listOfPlaces1.getListName());
    }

    //8-Como usuario quiero marcar en una lista los lugares a los que ya fui (sin eliminarlos de la lista)
    @Test
    public void markAsVisitedAPlace(){
        user1.markAsVisited(aPlace1);
        Assert.assertEquals("el MC",aPlace1.getName());
    }


}
