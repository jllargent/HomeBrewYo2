package edu.bsu.cs222.cnj.homebrewyo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class IngredientsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);
        Bundle bundle = getIntent().getExtras();
        int positionInRecipeIndex = bundle.getInt("recipePosition");
    }
}
