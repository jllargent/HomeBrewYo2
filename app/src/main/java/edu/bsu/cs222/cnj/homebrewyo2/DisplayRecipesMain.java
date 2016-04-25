package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DisplayRecipesMain extends AppCompatActivity {

    Intent intent = getIntent();
    List<Beer> recipeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_recipes_main);
        BeerListTransporter beerListTransporter = (BeerListTransporter) getIntent().getSerializableExtra("beerList");
        recipeList = beerListTransporter.getBeerList();
    }

    public void goNameRecipes(View view){
        Intent recipeNameIntent = new Intent(this, NameRecipeActivity.class);
        recipeNameIntent.putExtra("beerList", new BeerListTransporter((ArrayList<Beer>) recipeList));
        startActivity(recipeNameIntent);
    }

}
