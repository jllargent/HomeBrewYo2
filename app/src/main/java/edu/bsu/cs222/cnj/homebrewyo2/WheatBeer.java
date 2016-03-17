package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WheatBeer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheat_beer);
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
