package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RecipePage extends AppCompatActivity {

    private int positionInRecipeIndex;


    List<Beer> recipeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        Bundle bundle = getIntent().getExtras();
        recipeList = (List<Beer>) bundle.getSerializable("Recipe List");
        Log.i("from main recipe page", recipeList.toString());
        positionInRecipeIndex = bundle.getInt("recipePosition");
        fillUIInformation(positionInRecipeIndex);
    }

    public void goIngredients(View view){
        Intent recipeStyleIntent = new Intent(this, IngredientsPage.class);
        Bundle bundle = new Bundle();
        bundle.putInt("recipePosition", positionInRecipeIndex);
        bundle.putSerializable("Recipe List", (Serializable) recipeList);
        recipeStyleIntent.putExtras(bundle);
        startActivity(recipeStyleIntent);
    }

    //TODO: Clean Up DRY Violation
    public void fillUIInformation(int positionInRecipeIndex) {
        Beer currentBeer = recipeList.get(positionInRecipeIndex);
        setContentView(R.layout.activity_recipe);
        TextView nameTextView = (TextView) findViewById(R.id.textView16);
        assert nameTextView != null;
        nameTextView.setText(currentBeer.getName());

        TextView descriptionTextView = (TextView) findViewById(R.id.textView);
        assert descriptionTextView != null;
        descriptionTextView.setText(currentBeer.getDescription());


        TextView boilTimeTextView = (TextView) findViewById(R.id.textView3);
        assert boilTimeTextView != null;
        boilTimeTextView.setText("Boil for " + currentBeer.getTimeInMinutes() + " minutes at " + currentBeer.getTemperatureInFahrenheit() + "F");


        TextView fermentTextView = (TextView) findViewById(R.id.textView4);
        assert fermentTextView != null;
        fermentTextView.setText("Ferment at " + currentBeer.getFermentTemperature() + "F");


        TextView abvTextView = (TextView) findViewById(R.id.textView5);
        assert abvTextView != null;
        abvTextView.setText(currentBeer.getABVPercent() + "% | " + currentBeer.getIbuValue());


        TextView oGravTextView = (TextView) findViewById(R.id.textView7);
        assert oGravTextView != null;
        oGravTextView.setText("" + currentBeer.getTargetOriginalGravity());


        TextView fGravTextView = (TextView) findViewById(R.id.textView8);
        assert fGravTextView != null;
        fGravTextView.setText(""+currentBeer.getTargetFinalGravity());
    }

    public void goTimer(View view){
        Beer currentRecipe = recipeList.get(positionInRecipeIndex);
        int timerLength = currentRecipe.getTimeInMinutes() * 60;
        Intent timerIntent = new Intent(this, TimerActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("timerLength", timerLength);
        timerIntent.putExtras(bundle);
        startActivity(timerIntent);
    }
}
