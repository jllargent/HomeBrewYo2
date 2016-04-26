package edu.bsu.cs222.cnj.homebrewyo2;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class IngredientBuilderTest {

    Ingredient.IngredientBuilder builder;
    Ingredient testIngredient;

    @Before
    public void setUpIngredient(){
        builder = new Ingredient.IngredientBuilder();
        builder.createHopIngredient();
        builder.buildName("TESTING");
        builder.buildAmount(12);
        builder.buildTimeToAdd("Start");
        testIngredient = builder.getIngredient();
    }

    @Test
    public void testIngredientExists(){
        assertNotEquals(null, testIngredient);
    }

    @Test
    public void testIngredientHasName(){
        assertEquals("TESTING", testIngredient.getName());
    }

    @Test
    public void testIngredientHasAmount(){
        assertEquals(12, testIngredient.getAmount(), 0);
    }

    @Test
    public void testIngredientHasTimeToAdd(){
        assertEquals("Start", testIngredient.getTimingToAdd());
    }
}