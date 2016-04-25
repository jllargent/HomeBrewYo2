package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {

    NewXmlParser parser;
    public List<Beer> recipeList = new ArrayList<>();
    File xmlFile = new File("src/main/res/raw/beerrecipes.xml");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            runParser();
            recipeList = parser.getBeerList();
        }catch(Exception e){
        }
        Log.i("Heeeeepjgsurhluhsldfg", String.valueOf(recipeList));
    }

    public void goRecipes(View view){
        Intent recipeIntent = new Intent(this, DisplayRecipesMain.class);
        //Bundle bundle = new Bundle();
        //bundle.putSerializable("Recipe List", (Serializable) recipeList);

        Log.i("Gsajldhkashgdahsdhfaks", recipeList.toString());
        recipeIntent.putExtra("list", recipeList.toString());
        startActivity(recipeIntent);
    }

    public void goTimers(View view){
        Intent timerIntent = new Intent(this, TimerActivity.class);
        Bundle timerBundle = new Bundle();
        timerBundle.putInt("timerLength", 0);
        timerIntent.putExtras(timerBundle);
        startActivity(timerIntent);
    }

    private void runParser() throws IOException, ParserConfigurationException, SAXException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream resource = classLoader.getResourceAsStream("res/raw/beerrecipes.xml");
        parser = new NewXmlParser(resource);
    }


}
