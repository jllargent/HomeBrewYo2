package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.Serializable;
import java.util.List;

public class DisplayRecipesMain extends AppCompatActivity {

    Intent intent = getIntent();
    List<Beer> recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_recipes_main);
        Bundle bundle = getIntent().getExtras();
        recipeList = (List<Beer>) bundle.getSerializable("Recipe List");
    }

    public void goNameRecipes(View view){
        Intent recipeNameIntent = new Intent(this, NameRecipeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("RecipeList", (Serializable) recipeList);
        recipeNameIntent.putExtras(bundle);
        startActivity(recipeNameIntent);
    }

}
