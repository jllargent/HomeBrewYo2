package edu.bsu.cs222.cnj.homebrewyo2;

import android.app.Application;
import android.test.ApplicationTestCase;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class XmlParserUnitTest extends Application {


    private XMLFileProcessor parseInfo = new XMLFileProcessor(super.getApplicationContext());

    private ArrayList<Beer> listOfRecipies;
    private Beer riptide;
    private ArrayList<Malt> maltIngredients;
    private ArrayList<Malt> hopIngredients;



    @Before
    public void createTheListOfBeers() {
        listOfRecipies = parseInfo.getListOfBeers();
        riptide = listOfRecipies.get(3);

    }

    @Test
    public void isLengthOfRecipies10(){
        assertEquals(10, listOfRecipies.size());
    }





}
