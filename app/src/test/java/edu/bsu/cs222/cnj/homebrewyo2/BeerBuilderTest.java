package edu.bsu.cs222.cnj.homebrewyo2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BeerBuilderTest {
    Beer.BeerBuilder beerBuilder;
    Ingredient.IngredientBuilder ingredientBuilder;
    Ingredient testMalt;
    Ingredient secondMalt;
    Beer testBeer;
    Ingredient testHop;
    Ingredient secondHop;
    @Before
    public void setUpBeer(){
        beerBuilder = new Beer.BeerBuilder();
        ingredientBuilder = new Ingredient.IngredientBuilder();

        ingredientBuilder.createMaltIngredient();
        ingredientBuilder.buildName("TESTMALT");
        testMalt = ingredientBuilder.getIngredient();
        ingredientBuilder.createMaltIngredient();
        ingredientBuilder.buildName("TESTMALT2");
        secondMalt = ingredientBuilder.getIngredient();

        ingredientBuilder.createHopIngredient();
        ingredientBuilder.buildName("TESTHOP");
        testHop = ingredientBuilder.getIngredient();
        ingredientBuilder.createHopIngredient();
        ingredientBuilder.buildName("TESTHOP2");
        secondHop = ingredientBuilder.getIngredient();

        beerBuilder.createBeer();
        beerBuilder.buildName("test");
        beerBuilder.buildDescription("Test Description");
        beerBuilder.buildStyle("porter");
        beerBuilder.addMalt(testMalt);
        beerBuilder.addMalt(secondMalt);
        beerBuilder.addHop(testHop);
        beerBuilder.addHop(secondHop);
        beerBuilder.buildTime(5);
        testBeer = beerBuilder.getBeer();
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
        assertEquals("TESTMALT", testBeer.getMalts().get(0).getName());
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
        assertEquals("TESTHOP", testBeer.getHops().get(0).getName());
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

    @Test
    public void testBeerHasTargetFinalGravity(){
        assertNotEquals(null, testBeer.getTargetFinalGravity());
    }

    @Test
    public void testBeerHasTargetOriginalGravity(){
        assertNotEquals(null, testBeer.getTargetOriginalGravity());
    }
}