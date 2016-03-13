package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AmberAles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amber_ales);
    }
    public void goPhysicsRecipes(View view){
        Intent recipeStyleIntent = new Intent(this, Physics.class);
        startActivity(recipeStyleIntent);
    }
}
