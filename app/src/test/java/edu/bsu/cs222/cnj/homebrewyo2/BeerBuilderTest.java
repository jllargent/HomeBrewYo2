package edu.bsu.cs222.cnj.homebrewyo2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BeerBuilderTest {
    BeerBuilder builder;
    Malt testMalt;
    Beer testBeer;
    @Before
    public void setUpBeer(){
        builder = new RecipeBuilder();
        testMalt = new Malt();
        builder.createBeer();
        builder.buildName("test");
        builder.buildDescription("Test Description");
        builder.buildMalt(testMalt);
        testBeer = builder.getBeer();


    }

    @Test
    public void testBeerExist(){
        assertNotEquals(null, testBeer);
    }


    @Test
    public void testBeerHasName(){
        assertEquals("test", testBeer.getName());
    }

    @Test
    public void testBeerHasDescription(){
        assertEquals("Test Description", testBeer.getDescription());
    }

    @Test
    public void testBeerHasMalt(){
        assertNotEquals(null, testBeer.getMalts());
    }

}