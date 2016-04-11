package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DisplayRecipesMain extends AppCompatActivity {

    Intent intent = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_recipes_main);
    }

    public void goNameRecipes(View view){
        Intent recipeNameIntent = new Intent(this, NameRecipeActivity.class);
        startActivity(recipeNameIntent);
    }

}
