package edu.bsu.cs222.cnj.homebrewyo2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BeerBuilderTest {
    BeerBuilder builder;
    Malt testMalt;
    Malt secondMalt;
    Beer testBeer;
    @Before
    public void setUpBeer(){
        builder = new RecipeBuilder();
        testMalt = new Malt();
        secondMalt = new Malt();
        testMalt.setNameOfMalt("TESTMALT");
        builder.createBeer();
        builder.buildName("test");
        builder.buildDescription("Test Description");
        builder.buildMalt(testMalt);
        builder.buildMalt(secondMalt);
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

    @Test
    public void testBeerHasTestMalt(){
        assertEquals("TESTMALT", testBeer.getMalts().get(0).getNameOfMalt());
    }

    @Test
    public void testBeerHasMultipleMalts(){
        assertNotEquals(null, testBeer.getMalts().get(1));
    }

    @Test
    public void testBeerHasHop(){
        assertNotEquals(null, testBeer.getHops());
    }
}