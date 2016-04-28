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

    XmlParser parser;
    ArrayList<BeerRecipe> recipeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createPageLayout();

        try {
            runParser();
            recipeList = (ArrayList<BeerRecipe>) parser.getBeerRecipeList();
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
        timerBundle.putSerializable("Current Recipe", recipeList.get(0));
        timerIntent.putExtras(timerBundle);
        startActivity(timerIntent);
    }

    private void runParser() throws IOException, ParserConfigurationException, SAXException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream resource = classLoader.getResourceAsStream("res/raw/beerrecipes.xml");
        parser = new XmlParser(resource);
    }

    private void createPageLayout(){
        setContentView(R.layout.activity_main);
    }

}
