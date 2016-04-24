package edu.bsu.cs222.cnj.homebrewyo2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BeerBuilderTest {
    BeerBuilder builder;
    
    @Before
    public void setUpBeer(){
        builder = new RecipeBuilder();
        builder.createBeer();
        builder.buildName("test");
        builder.buildDescription("Test Description");
    }

    @Test
    public void testBeerExist(){
        assertNotEquals(null, builder.getBeer());
    }


    @Test
    public void testBeerHasName(){
        assertEquals("test", builder.getBeer().returnName());
    }

    @Test
    public void testBeerHasDescription(){
        assertEquals("Test Description", builder.getBeer().returnDescription());
    }

    @Test
    public void testBeerHasMalt(){
        assertNotEquals(null, builder.getBeer().returnMalts());
    }

}