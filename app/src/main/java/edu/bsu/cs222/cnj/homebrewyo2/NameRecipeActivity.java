package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NameRecipeActivity extends AppCompatActivity {

    Intent intent = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_recipe_scrollable);
    }
    public void goBadPixieRecipes(View view){
        Intent recipeStyleIntent = new Intent(this, BadPixie.class);
        startActivity(recipeStyleIntent);
    }

}
