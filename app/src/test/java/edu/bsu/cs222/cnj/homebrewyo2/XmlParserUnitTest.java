package edu.bsu.cs222.cnj.homebrewyo2;

import android.app.Application;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class XmlParserUnitTest extends Application {

    private ArrayList<Beer_New> listOfRecipies = new ArrayList<>();

    @Before
    public void createTheListOfBeers() {

        XMLFileProcessor_New parseInfo = new XMLFileProcessor_New(this);
        listOfRecipies=parseInfo.getListOfBeers();

    }


}
