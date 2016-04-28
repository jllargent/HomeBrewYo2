package edu.bsu.cs222.cnj.homebrewyo2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BeerRecipeBuilderTest {
    BeerRecipe.BeerBuilder beerBuilder;
    Ingredient.IngredientBuilder ingredientBuilder;
    Ingredient testMalt;
    Ingredient secondMalt;
    BeerRecipe testBeerRecipe;
    Ingredient testHop;
    Ingredient secondHop;

    @Before
    public void setUpBeer(){
        beerBuilder = new BeerRecipe.BeerBuilder();
        ingredientBuilder = new Ingredient.IngredientBuilder();

        ingredientBuilder.createIngredient();
        ingredientBuilder.buildName("TESTMALT");
        testMalt = ingredientBuilder.getIngredient();
        ingredientBuilder.createIngredient();
        ingredientBuilder.buildName("TESTMALT2");
        secondMalt = ingredientBuilder.getIngredient();

        ingredientBuilder.createIngredient();
        ingredientBuilder.buildName("TESTHOP");
        testHop = ingredientBuilder.getIngredient();
        ingredientBuilder.createIngredient();
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
        testBeerRecipe = beerBuilder.getBeer();
    }

    @Test
    public void testBeerExist(){
        assertNotEquals(null, testBeerRecipe);
    }


    @Test
    public void testBeerHasName() {
        assertEquals("test", testBeerRecipe.getName());
    }

    @Test
    public void testBeerHasDescription(){
        assertEquals("Test Description", testBeerRecipe.getDescription());
    }

    @Test
    public void testBeerHasMalt() {
        assertNotEquals(null, testBeerRecipe.getMalts());
    }

    @Test
    public void testBeerHasTestMalt() {
        assertEquals("TESTMALT", testBeerRecipe.getMalts().get(0).getName());
    }

    @Test
    public void testBeerHasMultipleMalts() {
        assertNotEquals(null, testBeerRecipe.getMalts().get(1));
    }

    @Test
    public void testBeerHasHop(){
        assertNotEquals(null, testBeerRecipe.getHops());
    }

    @Test
    public void testBeerHasTestHop() {
        assertEquals("TESTHOP", testBeerRecipe.getHops().get(0).getName());
    }

    @Test
    public void testBeerHasMultipleHops() {
        assertNotEquals(null, testBeerRecipe.getHops().get(1));
    }

    @Test
    public void testBeerHasTime(){
        assertNotEquals(null, testBeerRecipe.getTimeInMinutes());
    }

    @Test
    public void testBeerTime_5Minutes() {
        assertEquals(5, testBeerRecipe.getTimeInMinutes());
    }

    @Test
    public void testBeerHasTemp() {
        assertNotEquals(null, testBeerRecipe.getTemperatureInFahrenheit());
    }

    @Test
    public void testBeerHasStyle(){
        assertNotEquals(null, testBeerRecipe.getStyle());
    }

    @Test
    public void testBeerHasFermentTemp(){
        assertNotEquals(null, testBeerRecipe.getFermentTemperature());
    }

    @Test
    public void testBeerHasABVPercent(){
        assertNotEquals(null, testBeerRecipe.getABVPercent());
    }

    @Test
    public void testBeerHasIBUValue(){
        assertNotEquals(null, testBeerRecipe.getIbuValue());
    }

    @Test
    public void testBeerHasTargetFinalGravity(){
        assertNotEquals(null, testBeerRecipe.getTargetFinalGravity());
    }

    @Test
    public void testBeerHasTargetOriginalGravity(){
        assertNotEquals(null, testBeerRecipe.getTargetOriginalGravity());
    }
}