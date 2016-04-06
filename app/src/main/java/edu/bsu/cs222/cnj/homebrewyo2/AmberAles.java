package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class AmberAles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amber_ales);
    }
    public void goBeerRecipe(View view){
        int positionInRecipeIndex = Integer.parseInt(String.valueOf(view.getTag()));
        Intent recipeStyleIntent = new Intent(this, RecipePage.class);
        Bundle bundle = new Bundle();
        bundle.putInt("recipePosition", positionInRecipeIndex);
        recipeStyleIntent.putExtras(bundle);
        startActivity(recipeStyleIntent);
    }
}
