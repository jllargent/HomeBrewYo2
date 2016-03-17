package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PeroxidePunk extends AppCompatActivity {

    private Button timeSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peroxide_punk);

        timeSet = (Button) findViewById(R.id.perPunkTimer);
        timeSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimerActivity.setTime(75 * 60);
            }
        });
    }
    public void goPeroxidePunkIngredients(View view){
        Intent onClick = new Intent(this, PeroxidePunkIngredients.class);
        startActivity(onClick);
    }
}
