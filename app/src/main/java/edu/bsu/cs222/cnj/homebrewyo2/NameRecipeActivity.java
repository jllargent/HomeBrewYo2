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
        setContentView(R.layout.activity_name_recipe);
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
}
