package edu.bsu.cs222.cnj.homebrewyo2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BeerBuilderTest {
    BeerBuilder builder;
    
    @Before
    public void setUpBeer(){
        builder = new BeerBuilder();
    }

    @Test
    public void testBeerHasName(){
        assertEquals("test", builder.thisBeer.returnName());
    }



}
