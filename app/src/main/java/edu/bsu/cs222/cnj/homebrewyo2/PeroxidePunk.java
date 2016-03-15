package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PeroxidePunk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peroxide_punk);
    }
    public void goPeroxidePunkIngredients(View view){
        Intent onClick = new Intent(this, PeroxidePunkIngredients.class);
        startActivity(onClick);
    }
}
