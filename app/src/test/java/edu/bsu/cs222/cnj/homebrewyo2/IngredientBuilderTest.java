package edu.bsu.cs222.cnj.homebrewyo2;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class IngredientBuilderTest {

    Ingredient.IngredientBuilder builder;
    Ingredient testHop;
    Ingredient testYeast;

    @Before
    public void setUpIngredient(){
        builder = new Ingredient.IngredientBuilder();
        builder.createIngredient();
        builder.buildName("TESTING");
        builder.buildAmount(12);
        builder.buildTimeToAdd("Start");
        testHop = builder.getIngredient();

        builder.createIngredient();
        builder.buildName("testYeast");
        testYeast = builder.getIngredient();
    }

    @Test
    public void testIngredientExists(){
        assertNotEquals(null, testHop);
    }

    @Test
    public void testIngredientHasName(){
        assertEquals("TESTING", testHop.getName());
    }

    @Test
    public void testIngredientHasAmount(){
        assertEquals(12, testHop.getAmount(), 0);
    }

    @Test
    public void testIngredientHasTimeToAdd(){
        assertEquals("Start", testHop.getTimingToAdd());
    }

    @Test
    public void testThatThereIsYeastIngredient(){
        assertNotEquals(null, testYeast);
    }

    @Test
    public void testYeastHasName(){
        assertEquals("testYeast", testYeast.getName());
    }
}