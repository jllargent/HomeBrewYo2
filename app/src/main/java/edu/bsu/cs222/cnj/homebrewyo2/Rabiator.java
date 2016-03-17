package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Rabiator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rabiator);
    }
    public void goRabiatorIngredients(View view){
        Intent onClick = new Intent(this, RabiatorIngredients.class);
        startActivity(onClick);
    }
}
