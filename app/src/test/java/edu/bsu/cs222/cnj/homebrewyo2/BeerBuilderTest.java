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
    Hop testHop;
    Hop secondHop;
    @Before
    public void setUpBeer(){
        builder = new RecipeBuilder();
        testMalt = new Malt();
        secondMalt = new Malt();
        testHop = new Hop();
        secondHop = new Hop();
        testMalt.setNameOfMalt("TESTMALT");
        testHop.setNameOfHop("TESTHOP");
        builder.createBeer();
        builder.buildName("test");
        builder.buildDescription("Test Description");
        builder.buildStyle("porter");
        builder.buildMalt(testMalt);
        builder.buildMalt(secondMalt);
        builder.buildHop(testHop);
        builder.buildHop(secondHop);
        builder.buildTime(5);
        testBeer = builder.getBeer();
    }

    @Test
    public void testBeerExist(){
        assertNotEquals(null, testBeer);
    }


    @Test
    public void testBeerHasName() {
        assertEquals("test", testBeer.getName());
    }

    @Test
    public void testBeerHasDescription(){
        assertEquals("Test Description", testBeer.getDescription());
    }

    @Test
    public void testBeerHasMalt() {
        assertNotEquals(null, testBeer.getMalts());
    }

    @Test
    public void testBeerHasTestMalt() {
        assertEquals("TESTMALT", testBeer.getMalts().get(0).getNameOfMalt());
    }

    @Test
    public void testBeerHasMultipleMalts() {
        assertNotEquals(null, testBeer.getMalts().get(1));
    }

    @Test
    public void testBeerHasHop(){
        assertNotEquals(null, testBeer.getHops());
    }

    @Test
    public void testBeerHasTestHop() {
        assertEquals("TESTHOP", testBeer.getHops().get(0).getNameOfHop());
    }

    @Test
    public void testBeerHasMultipleHops() {
        assertNotEquals(null, testBeer.getHops().get(1));
    }

    @Test
    public void testBeerHasTime(){
        assertNotEquals(null, testBeer.getTimeInMinutes());
    }

    @Test
    public void testBeerTime_5Minutes() {
        assertEquals(5, testBeer.getTimeInMinutes());
    }

    @Test
    public void testBeerHasTemp() {
        assertNotEquals(null, testBeer.getTemperatureInFahrenheit());
    }

    @Test
    public void testBeerHasStyle(){
        assertNotEquals(null, testBeer.getStyle());
    }

    @Test
    public void testBeerHasFermentTemp(){
        assertNotEquals(null, testBeer.getFermentTemperature());
    }

    @Test
    public void testBeerHasABVPercent(){
        assertNotEquals(null, testBeer.getABVPercent());
    }

    @Test
    public void testBeerHasIBUValue(){
        assertNotEquals(null, testBeer.getIbuValue());
    }
}