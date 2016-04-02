package edu.bsu.cs222.cnj.homebrewyo2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class IngredientsClassUnitTest {
    Ingredients ingredients = new Ingredients();
    Malt wheat = new Malt();
    Malt extraPale = new Malt();
    Hop gold = new Hop();
    Hop lemon = new Hop();

    ArrayList<Malt> listOfMalts = new ArrayList<>();
    ArrayList<Hop> listOfHops = new ArrayList<>();

    @Before
    public void createIngredients() {
        wheat.setNameOfMalt("wheat");
        wheat.setWeightOfMaltsInPounds(5.5);
        ingredients.addToMaltsList(wheat);

        ingredients.addToMaltsList(extraPale);

        gold.setNameOfHop("First Gold");
        gold.setAmountOfHopsInGrams(18.75);
        ingredients.addToHopsList(gold);

        ingredients.addToHopsList(lemon);

        ingredients.setYeast("testYeast");

        listOfMalts = ingredients.getListOfMalts();
        listOfHops = ingredients.getListOfHops();
    }

    @Test
    public void ingredientsHasListOfMalts_ListSizeIs2(){
        assertEquals(2, listOfMalts.size());
    }

    @Test
    public void ingredientsHasListOfHops_ListSizeIs2(){
        assertEquals(2, listOfHops.size());
    }

    @Test
    public void ingredientsHasYeast_YeastIsTestYeast(){
        assertEquals("testYeast", ingredients.getYeast());
    }

    @Test
    public void maltHasName_NameIsWheat(){
        assertEquals("wheat", listOfMalts.get(0).getNameOfMalt() );
    }

    @Test
    public void maltHasAmount_AmountIs55(){
        assertEquals("5.5lbs", listOfMalts.get(0).getAmountOfMalt());
    }



}