package edu.bsu.cs222.cnj.homebrewyo2;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class IngredientBuilderTest {

    IngredientBuilder builder;
    Ingredient testIngredient;

    @Before
    public void setUpIngredient(){
        builder = new IngredientBuilder();
        builder.createMaltIngredient();
        builder.setName("TESTING");
        builder.setAmount(12);
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
}