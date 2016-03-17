package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BrixtonPorter extends AppCompatActivity {

    private Button timeSet = (Button) findViewById(R.id.brixPortTimer);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brixton_porter);

        timeSet = (Button) findViewById(R.id.brixPortTimer);
        timeSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimerActivity.setTime(75 * 60);
            }
        });
    }
    public void goBrixtonPorterIngredients(View view){
        Intent onClick = new Intent(this, BrixtonPorterIngredients.class);
        startActivity(onClick);
    }
}