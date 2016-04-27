package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {

    NewXmlParser parser;
    ArrayList<Beer> recipeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            runParser();
            recipeList = (ArrayList<Beer>) parser.getBeerList();
        }catch(Exception e){
        }
    }

    public void goRecipes(View view){
        Intent recipeIntent = new Intent(this, DisplayRecipesMain.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Recipe List", recipeList);
        recipeIntent.putExtras(bundle);
        startActivity(recipeIntent);
    }

    public void goTimers(View view){
        Intent timerIntent = new Intent(this, TimerActivity.class);
        Bundle timerBundle = new Bundle();
        timerBundle.putSerializable("Recipe List", recipeList);
        timerBundle.putInt("timerLength", 0);
        timerBundle.putInt("recipePosition", 1);
        timerIntent.putExtras(timerBundle);
        startActivity(timerIntent);
    }

    private void runParser() throws IOException, ParserConfigurationException, SAXException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream resource = classLoader.getResourceAsStream("res/raw/beerrecipes.xml");
        parser = new NewXmlParser(resource);
    }


}
