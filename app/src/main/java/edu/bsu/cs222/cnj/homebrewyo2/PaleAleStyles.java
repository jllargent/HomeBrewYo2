package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PaleAleStyles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pale_ale_styles);
    }
    public void goPeroxidePunkRecipes(View view){
        Intent recipeStyleIntent = new Intent(this, PeroxidePunk.class);
        startActivity(recipeStyleIntent);
    }
}