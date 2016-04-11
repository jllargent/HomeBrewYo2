package edu.bsu.cs222.cnj.homebrewyo2;

import android.app.Application;
import android.test.ApplicationTestCase;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class XmlParserUnitTest extends Application {


    private XMLFileProcessor parseInfo = new XMLFileProcessor(super.getApplicationContext());

    private ArrayList<Beer> listOfRecipies;
    private Beer riptide;
    private ArrayList<Malt> maltIngredients;
    private ArrayList<Malt> hopIngredients;



    @Before
    public void createTheListOfBeers() {
        listOfRecipies = parseInfo.getListOfBeers();
        riptide = listOfRecipies.get(2);

    }

    @Test
    public void isLengthOfRecipies10(){
        assertEquals(10, listOfRecipies.size());
    }
    @Test
    public void isRiptideBeer2(){
        String nameOfBeer = riptide.getTitleOfBeer();
        assertEquals("Riptide", nameOfBeer);
    }

    @Test
    public void isThere7MaltsForRiptide(){
        int sizeOfMaltList = riptide.getMaltIngredients().size();
        assertEquals(7, sizeOfMaltList);
    }
    @Test
    public void isMaltIngredient3ForRiptideCaramalt(){
        String nameOfMalt = riptide.getMaltIngredients().get(3).getNameOfMalt();
        assertEquals("Caramalt", nameOfMalt);
    }
    @Test
    public void isAmountOfMaltIngredient2ForRiptide12lb(){
        String amountOfMalt = riptide.getMaltIngredients().get(1).getAmountOfMalt();
        assertEquals("1.2lb", amountOfMalt);
    }

    @Test
    public void isThere5HopsForRiptide(){
        int sizeOfHopList = riptide.getHopIngredients().size();
        assertEquals(5, sizeOfHopList);
    }
    @Test
    public void isHopIngredient4ForRiptideColumbus(){
        String nameOfHop = riptide.getHopIngredients().get(4).getNameOfHop();
        assertEquals("Columbus", nameOfHop);
    }
    @Test
    public void isAmountOfHopIngredient0ForRiptide143g(){
        String amountOfHop = riptide.getHopIngredients().get(0).getAmountOfHops();
        assertEquals("14.3g", amountOfHop);
    }
    @Test
    public void isStartTimeForHopIngredient1ForRiptideStart(){
        String timeToPlaceHop = riptide.getHopIngredients().get(1).getTimeToAddHop();
        assertEquals("Start", timeToPlaceHop);
    }

}
