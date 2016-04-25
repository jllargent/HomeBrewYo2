package edu.bsu.cs222.cnj.homebrewyo2;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class IngredientBuilderTest {

    IngredientBuilder builder;

    @Before
    public void setUpIngredient(){
        builder = new IngredientBuilder();
        builder.createMaltIngredient();
        builder.setName("TESTING");
    }

    @Test
    public void testIngredientExists(){
        assertNotEquals(null, builder.getIngredient());
    }

    @Test
    public void testIngredientHasName(){
        assertEquals("TESTING", builder.getName());
    }
}