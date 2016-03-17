package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Riptide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riptide);
    }
    public void goRiptideIngredients(View view){
        Intent onClick = new Intent(this, RiptideIngredients.class);
        startActivity(onClick);
    }
}

