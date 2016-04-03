package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        XMLFileProcessor_New parseInfo = new XMLFileProcessor_New(this);
        ArrayList<Beer_New> listOfRecipies = new ArrayList<>();
        listOfRecipies = parseInfo.getListOfBeers();
        /*
        Log.i("Testing Info Title", listOfRecipies.get(0).getTitleOfBeer());

        Log.i("Testing Info Style", listOfRecipies.get(0).getStyleOfBeer());

        Log.i("Testing Info Descriptio", listOfRecipies.get(0).getDescriptionOfBeer());*/

    }

    public void goRecipes(View view){
        Intent recipeIntent = new Intent(this, DisplayRecipesMain.class);
        startActivity(recipeIntent);
    }

    public void goTimers(View view){
        Intent timerIntent = new Intent(this, TimerActivity.class);
        startActivity(timerIntent);
    }




}
