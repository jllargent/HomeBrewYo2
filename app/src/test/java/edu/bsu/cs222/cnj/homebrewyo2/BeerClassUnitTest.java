package edu.bsu.cs222.cnj.homebrewyo2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BeerClassUnitTest {
    private Beer testBeer = new Beer();
    private String description = "This is a description to test.";

    @Before
    public void createTestBeerElements(){
        testBeer.setTitleOfBeer("Test Beer");
        testBeer.setStyleOfBeer("TestingBeerType");
        testBeer.setDescriptionOfBeer(description);
        testBeer.setValueOfABV("5%");
        testBeer.setTimeInMins("75");
        testBeer.setBoilDescription("Boil for 75 minutes at 150F");
        testBeer.setFermentTemperature("Ferment at 66F");
        testBeer.setOriginalGravity("1111");
        testBeer.setFinalGravity("1000");
    }

    @Test
    public void titleOfBeer_isCorrect() {
        assertEquals("Test Beer", testBeer.getTitleOfBeer());
    }

    @Test
    public void styleOfBeer_isCorrect(){
        assertEquals("TestingBeerType", testBeer.getStyleOfBeer());
    }

    @Test
    public void descriptionOfBeer_isCorrect(){
        assertEquals(description, testBeer.getDescriptionOfBeer());
    }

    @Test
    public void aBVValue_isCorrect(){
        assertEquals( "5%", testBeer.getValueOfABV());
    }

    @Test
    public void time_isCorrect(){
        assertEquals(75, testBeer.getTimeInMins());
    }

    @Test
    public void boilDescription_isCorrect(){
        assertEquals("Boil for 75 minutes at 150F", testBeer.getBoilDescription());
    }

    @Test
    public void fermentTemperature_isCorrect(){
        assertEquals("Ferment at 66F", testBeer.getFermentTemp());
    }

    @Test
    public void orginalGravity_isCorrect(){
        assertEquals("1111",testBeer.getOriginalGravity() );
    }

    @Test
    public void finalGravity_isCorrect(){
        assertEquals("1000", testBeer.getFinalGravity());
    }


}

