package edu.bsu.cs222.cnj.homebrewyo2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BeerClassUnitTest {
    Beer testBeer = new Beer("Test Beer");
    String description = "This is a description to test.";

    @Before
    public void createTestBeerElements(){
        testBeer.setStyleOfBeer("TestingBeerType");
        testBeer.setDescriptionOfBeer(description);
        testBeer.setValueOfABV(5);
    }

    @Test
    public void titleOfBeer_isCorrect(){
        assertEquals("Test Beer", testBeer.getTitleOfBeer());
    }



}
