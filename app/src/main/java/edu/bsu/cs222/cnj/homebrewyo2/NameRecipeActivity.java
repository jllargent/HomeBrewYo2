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
        setContentView(R.layout.activity_name_recipe_2);
    }
    public void goDogmaRecipes(View view){
        Intent recipeStyleIntent = new Intent(this, Dogma.class);
        startActivity(recipeStyleIntent);
    }
    public void goPhysicsRecipes(View view){
        Intent recipeStyleIntent = new Intent(this, Physics.class);
        startActivity(recipeStyleIntent);
    }
    public void goPunkRecipes(View view){
        Intent recipeStyleIntent = new Intent(this, Punk.class);
        startActivity(recipeStyleIntent);
    }
    public void goHoprockerRecipes(View view){
        Intent recipeStyleIntent = new Intent(this, Hoprocker.class);
        startActivity(recipeStyleIntent);
    }
    public void goPeroxidePunkIngredients(View view){
        Intent onClick = new Intent(this, PeroxidePunk.class);
        startActivity(onClick);
    }
    public void goBrixtonPorter(View view){
        Intent onClick = new Intent(this, BrixtonPorter.class);
        startActivity(onClick);
    }
    public void goRiptideIngredients(View view){
        Intent onClick = new Intent(this, Riptide.class);
        startActivity(onClick);
    }
    public void goCoffeeImpRecipes(View view){
        Intent recipeStyleIntent = new Intent(this, CoffeeImperialStout.class);
        startActivity(recipeStyleIntent);
    }
    public void goBadPixieRecipes(View view){
        Intent recipeStyleIntent = new Intent(this, BadPixie.class);
        startActivity(recipeStyleIntent);
    }
    public void goRabiatorRecipes(View view){
        Intent recipeStyleIntent = new Intent(this, Rabiator.class);
        startActivity(recipeStyleIntent);
    }
}
