package edu.bsu.cs222.cnj.homebrewyo2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BeerClassUnitTest {
    Beer_New testBeer = new Beer_New();
    String description = "This is a description to test.";

    @Before
    public void createTestBeerElements(){
        testBeer.setTitleOfBeer("Test Beer");
        testBeer.setStyleOfBeer("TestingBeerType");
        testBeer.setDescriptionOfBeer(description);
        testBeer.setValueOfABV("5%");
    }

    @Test
    public void titleOfBeer_isCorrect(){
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
}

