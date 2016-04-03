package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecipePage extends AppCompatActivity {

    private Button timeSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        timeSet = (Button) findViewById(R.id.badPixTimer);
        timeSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimerActivity.setTime(75 * 60);
            }
        });
    }

    public void goBadPixieIngredients(View view){
        Intent onClick = new Intent(this, IngredientsPage.class);
        startActivity(onClick);
    }
}
