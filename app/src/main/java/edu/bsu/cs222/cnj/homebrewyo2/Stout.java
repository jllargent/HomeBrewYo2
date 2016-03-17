package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Stout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stout);
    }
    public void goRiptideRecipes(View view){
        Intent recipeStyleIntent = new Intent(this, Riptide.class);
        startActivity(recipeStyleIntent);
    }
    public void goCoffeeImpRecipes(View view){
        Intent recipeStyleIntent = new Intent(this, CoffeeImperialStout.class);
        startActivity(recipeStyleIntent);
    }

}
