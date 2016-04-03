package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class NameRecipeActivity extends AppCompatActivity {

    Intent intent = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_recipe_scrollable);
    }
    public void goBeerRecipe(View view){
        int positionInRecipeIndex = Integer.parseInt((String) String.valueOf(view.getTag()));
        Log.i("testing", "" + positionInRecipeIndex);
        //startActivity(new Intent(getBaseContext(), activities.get(i)));
        Intent recipeStyleIntent = new Intent(this, RecipePage.class);
        startActivity(recipeStyleIntent);
    }

}
