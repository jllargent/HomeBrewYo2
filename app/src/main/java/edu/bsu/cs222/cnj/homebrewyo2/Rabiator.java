package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Rabiator extends AppCompatActivity {

    Button timeSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rabiator);

        timeSet = (Button) findViewById(R.id.rabTimer);
        timeSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimerActivity.setTime(60 * 60);
            }
        });
    }
    public void goRabiatorIngredients(View view){
        Intent onClick = new Intent(this, RabiatorIngredients.class);
        startActivity(onClick);
    }
}
