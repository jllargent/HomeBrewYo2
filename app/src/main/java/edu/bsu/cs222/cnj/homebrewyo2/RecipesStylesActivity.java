package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RecipesStylesActivity extends AppCompatActivity {

    Intent intent = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_styles_linear);
    }

    public void goAleStyleRecipes(View view){
        Intent recipeStyleIntent = new Intent(this, StylesAles.class);
        startActivity(recipeStyleIntent);
    }
    public void goAmberAleStyleRecipes(View view){
        Intent recipeStyleIntent = new Intent(this, AmberAles.class);
        startActivity(recipeStyleIntent);
    }
    public void goIPAStyleRecipes(View view){
        Intent recipeStyleIntent = new Intent(this, IPAStyle.class);
        startActivity(recipeStyleIntent);
    }
    public void goLagerStyleRecipes(View view){
        Intent recipeStyleIntent = new Intent(this, Lagers.class);
        startActivity(recipeStyleIntent);
    }
    public void goPaleAleRecipes(View view){
        Intent recipeStyleIntent = new Intent(this, PaleAleStyles.class);
        startActivity(recipeStyleIntent);
    }
    public void goPorterRecipes(View view){
        Intent recipeStyleIntent = new Intent(this, PorterStyles.class);
        startActivity(recipeStyleIntent);
    }
    public void goStoutRecipes(View view){
        Intent recipeStyleIntent = new Intent(this, Stout.class);
        startActivity(recipeStyleIntent);
    }
    public void goWheatRecipes(View view){
        Intent recipeStyleIntent = new Intent(this, WheatBeer.class);
        startActivity(recipeStyleIntent);
    }
}
