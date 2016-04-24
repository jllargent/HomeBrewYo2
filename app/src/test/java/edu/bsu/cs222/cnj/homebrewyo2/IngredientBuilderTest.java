package edu.bsu.cs222.cnj.homebrewyo2;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertNotEquals;

public class IngredientBuilderTest {

    IngredientBuilder builder;

    @Before
    public void setUpIngredient(){
        builder.createYeastIngredient();
    }

    @Test
    public void testIngredientExists(){
        assertNotEquals(null, builder.getIngredient());
    }
}