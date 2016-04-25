package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {

    NewXmlParser parser;
    List<Beer> recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            runParser(R.raw.beerrecipes);
            recipeList = parser.getBeerList();
        }catch(Exception e) {
            Log.i("damn it", String.valueOf(e));
        }
        Log.i("HELPPPPPPPPPPPP", String.valueOf(recipeList));

    }

    public void goRecipes(View view){
        Intent recipeIntent = new Intent(this, DisplayRecipesMain.class);
        recipeIntent.putExtra("beerList", new BeerListTransporter((ArrayList<Beer>) recipeList));
        startActivity(recipeIntent);
    }

    public void goTimers(View view){
        Intent timerIntent = new Intent(this, TimerActivity.class);
        Bundle timerBundle = new Bundle();
        timerBundle.putInt("timerLength", 0);
        timerIntent.putExtras(timerBundle);
        startActivity(timerIntent);
    }

    private void runParser(File fileToParse) throws IOException, ParserConfigurationException, SAXException {
        URL input = fileToParse.toURI().toURL();
        parser = new NewXmlParser(input.openStream());
        Log.i("Im running", "");
    }

}
