package edu.bsu.cs222.cnj.homebrewyo2;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.test.ApplicationTestCase;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class XmlParserUnitTest extends ApplicationTestCase {

    private ArrayList<Beer_New> listOfRecipies = new ArrayList<>();
    private ArrayList<Malt> maltIngredients;

    public XmlParserUnitTest(Class applicationClass) {
        super(applicationClass);
    }

    @Before
    public void createTheListOfBeers() {

        XMLFileProcessor_New parseInfo = new XMLFileProcessor_New(super.getContext());
        listOfRecipies=parseInfo.getListOfBeers();

    }

    @Test
    public void isMaltAmountOnBeer01171lbs(){
        maltIngredients = listOfRecipies.get(2).getMaltIngredients();
        assertEquals(maltIngredients.get(2).getNameOfMalt(), "Caramalt");
    }


}
