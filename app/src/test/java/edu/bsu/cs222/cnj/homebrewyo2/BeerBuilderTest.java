package edu.bsu.cs222.cnj.homebrewyo2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BeerBuilderTest {
    BeerBuilder builder = new BeerBuilder();
    Beer testBeer = new Beer("test");

    @Test
    public void testBeerHasName(){
        assertEquals("test", testBeer.returnName());
    }

}
