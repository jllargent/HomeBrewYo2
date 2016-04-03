package edu.bsu.cs222.cnj.homebrewyo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class StoreParserInfo extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        XMLFileProcessor_New parseInfo = new XMLFileProcessor_New(this);
        ArrayList<Beer> listOfRecipies = new ArrayList<>();
        listOfRecipies = parseInfo.getListOfBeers();

        

    }
}
