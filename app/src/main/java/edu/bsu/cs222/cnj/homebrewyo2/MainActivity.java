package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {

    NewXmlParser parser;
    List<Beer> recipeList = new ArrayList<>();
    File xmlFile = new File("src/main/res/raw/beerrecipes.xml");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            runParser(xmlFile);
            recipeList = parser.getBeerList();
        }catch(Exception e){
        }
    }

    public void goRecipes(View view){
        Intent recipeIntent = new Intent(this, DisplayRecipesMain.class);
        startActivity(recipeIntent);
    }

    public void goTimers(View view){
        Intent timerIntent = new Intent(this, TimerActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("timerLength", 0);
        timerIntent.putExtras(bundle);
        startActivity(timerIntent);
    }

    private void runParser(File fileToParse) throws IOException, ParserConfigurationException, SAXException {
        URL input = xmlFile.toURI().toURL();
        parser = new NewXmlParser(input.openStream());
    }


}
