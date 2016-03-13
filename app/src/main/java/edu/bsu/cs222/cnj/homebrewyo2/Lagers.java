package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Lagers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lagers);
    }
    public void goHoprockerRecipes(View view){
        Intent recipeStyleIntent = new Intent(this, Hoprocker.class);
        startActivity(recipeStyleIntent);
    }
}
