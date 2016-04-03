package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class StylesAles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_styles_ales);
    }
    public void goBeerRecipe(View view){
        int i = Integer.parseInt((String) String.valueOf(view.getTag()));
        Log.i("testing", "" + i);
        //startActivity(new Intent(getBaseContext(), activities.get(i)));
        Intent recipeStyleIntent = new Intent(this, RecipePage.class);
        startActivity(recipeStyleIntent);
    }

}
