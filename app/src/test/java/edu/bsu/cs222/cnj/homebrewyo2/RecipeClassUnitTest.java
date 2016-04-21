package edu.bsu.cs222.cnj.homebrewyo2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeClassUnitTest {
    private Recipe testRecipe = new Recipe();
    private String description = "This is a description to test.";

    @Before
    public void createTestBeerElements(){
        testRecipe.setTitleOfBeer("Test Recipe");
        testRecipe.setStyleOfBeer("TestingBeerType");
        testRecipe.setDescriptionOfBeer(description);
        testRecipe.setValueOfABV("5%");
        testRecipe.setTimeInMins("75");
        testRecipe.setBoilDescription("Boil for 75 minutes at 150F");
        testRecipe.setFermentTemperature("Ferment at 66F");
        testRecipe.setOriginalGravity("1111");
        testRecipe.setFinalGravity("1000");
    }

    @Test
    public void titleOfBeer_isCorrect() {
        assertEquals("Test Recipe", testRecipe.getTitleOfBeer());
    }

    @Test
    public void styleOfBeer_isCorrect(){
        assertEquals("TestingBeerType", testRecipe.getStyleOfBeer());
    }

    @Test
    public void descriptionOfBeer_isCorrect(){
        assertEquals(description, testRecipe.getDescriptionOfBeer());
    }

    @Test
    public void aBVValue_isCorrect(){
        assertEquals( "5%", testRecipe.getValueOfABV());
    }

    @Test
    public void time_isCorrect(){
        assertEquals(75, testRecipe.getTimeInMins());
    }

    @Test
    public void boilDescription_isCorrect(){
        assertEquals("Boil for 75 minutes at 150F", testRecipe.getBoilDescription());
    }

    @Test
    public void fermentTemperature_isCorrect(){
        assertEquals("Ferment at 66F", testRecipe.getFermentTemp());
    }

    @Test
    public void orginalGravity_isCorrect(){
        assertEquals("1111", testRecipe.getOriginalGravity() );
    }

    @Test
    public void finalGravity_isCorrect(){
        assertEquals("1000", testRecipe.getFinalGravity());
    }


}

