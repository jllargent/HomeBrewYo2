package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CoffeeImperialStout extends AppCompatActivity {

    private Button timeSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_imperial_stout);

        timeSet = (Button) findViewById(R.id.impStoutTimer);
        timeSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimerActivity.setTime(90 * 60);
            }
        });
    }
    public void goCoffeeImpIngredients(View view){
        Intent onClick = new Intent(this, CoffeeImperialIngredients.class);
        startActivity(onClick);
    }
}
