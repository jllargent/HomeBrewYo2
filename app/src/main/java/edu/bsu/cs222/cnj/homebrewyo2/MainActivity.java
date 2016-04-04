package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goRecipes(View view){
        Intent recipeIntent = new Intent(this, DisplayRecipesMain.class);
        startActivity(recipeIntent);
    }

    public void goTimers(View view){
        Intent timerIntent = new Intent(this, TimerActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("timerLength", 0);
        timerIntent.putExtras(bundle);
        startActivity(timerIntent);
    }




}
