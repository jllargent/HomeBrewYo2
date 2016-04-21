package edu.bsu.cs222.cnj.homebrewyo2;

import android.app.Application;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

//TODO: Find Out Why Parser Doesn't obtain File While Testing Goes Stright To Throw
public class XmlParserUnitTest extends Application {


    private XMLFileProcessor parseInfo = new XMLFileProcessor();

    private ArrayList<Recipe> listOfRecipies;
    private Recipe riptide;
    private ArrayList<Malt> maltIngredientsForRiptide;
    private ArrayList<Hop> hopIngredientsForRiptide;



    @Before
    public void createTheListOfBeers() {
        listOfRecipies = parseInfo.getListOfRecipes();
        riptide = listOfRecipies.get(2);
        maltIngredientsForRiptide = listOfRecipies.get(2).getMaltIngredients();
        hopIngredientsForRiptide = listOfRecipies.get(2).getHopIngredients();
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
        int sizeOfMaltList = maltIngredientsForRiptide.size();
        assertEquals(7, sizeOfMaltList);
    }
    @Test
    public void isMaltIngredient3ForRiptideCaramalt(){
        String nameOfMalt = maltIngredientsForRiptide.get(3).getNameOfMalt();
        assertEquals("Caramalt", nameOfMalt);
    }
    @Test
    public void isAmountOfMaltIngredient2ForRiptide12lb(){
        String amountOfMalt = maltIngredientsForRiptide.get(1).getAmountOfMalt();
        assertEquals("1.2lb", amountOfMalt);
    }

    @Test
    public void isThere5HopsForRiptide(){
        int sizeOfHopList = hopIngredientsForRiptide.size();
        assertEquals(5, sizeOfHopList);
    }
    @Test
    public void isHopIngredient4ForRiptideColumbus(){
        String nameOfHop = hopIngredientsForRiptide.get(4).getNameOfHop();
        assertEquals("Columbus", nameOfHop);
    }
    @Test
    public void isAmountOfHopIngredient0ForRiptide143g(){
        String amountOfHop = hopIngredientsForRiptide.get(0).getAmountOfHops();
        assertEquals("14.3g", amountOfHop);
    }
    @Test
    public void isStartTimeForHopIngredient1ForRiptideStart(){
        String timeToPlaceHop = hopIngredientsForRiptide.get(1).getTimeToAddHop();
        assertEquals("Start", timeToPlaceHop);
    }

}
