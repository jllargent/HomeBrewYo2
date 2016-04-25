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
        Bundle bundle = getIntent().getExtras();
        recipeList = (List<Beer>) bundle.getSerializable("Recipe List");
        Log.i("Array List fucker", recipeList.toString());
    }

    public void goNameRecipes(View view){
        Intent recipeNameIntent = new Intent(this, NameRecipeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Recipe List", (Serializable) recipeList);
        Log.i("Gsajldhkashgdahsdhfaks", recipeList.toString());
        recipeNameIntent.putExtras(bundle);
        startActivity(recipeNameIntent);
    }

}
