package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecipePage extends AppCompatActivity {

    private int positionInRecipeIndex;
    private List<Beer> recipeList = new ArrayList<>();
    private Beer currentRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        createCurrentRecipe();
        fillUIInformation();
    }

    public void goIngredients(View view){
        Intent recipeStyleIntent = new Intent(this, IngredientsPage.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Current Recipe", currentRecipe);
        recipeStyleIntent.putExtras(bundle);
        startActivity(recipeStyleIntent);
    }

    //TODO: Clean Up DRY Violation
    public void fillUIInformation() {

        setContentView(R.layout.activity_recipe);
        TextView nameTextView = (TextView) findViewById(R.id.textView16);
        assert nameTextView != null;
        nameTextView.setText(currentRecipe.getName());

        TextView descriptionTextView = (TextView) findViewById(R.id.textView);
        assert descriptionTextView != null;
        descriptionTextView.setText(currentRecipe.getDescription());


        TextView boilTimeTextView = (TextView) findViewById(R.id.textView3);
        assert boilTimeTextView != null;
        boilTimeTextView.setText("Boil for " + currentRecipe.getTimeInMinutes() + " minutes at " + currentRecipe.getTemperatureInFahrenheit() + "F");


        TextView fermentTextView = (TextView) findViewById(R.id.textView4);
        assert fermentTextView != null;
        fermentTextView.setText("Ferment at " + currentRecipe.getFermentTemperature() + "F");


        TextView abvTextView = (TextView) findViewById(R.id.textView5);
        assert abvTextView != null;
        abvTextView.setText(currentRecipe.getABVPercent() + "% | " + currentRecipe.getIbuValue());


        TextView oGravTextView = (TextView) findViewById(R.id.textView7);
        assert oGravTextView != null;
        oGravTextView.setText("" + currentRecipe.getTargetOriginalGravity());


        TextView fGravTextView = (TextView) findViewById(R.id.textView8);
        assert fGravTextView != null;
        fGravTextView.setText("" + currentRecipe.getTargetFinalGravity());
    }

    public void goTimer(View view){
        int timerLength = currentRecipe.getTimeInMinutes() * 60;
        Intent timerIntent = new Intent(this, TimerActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Current Recipe", currentRecipe);
        bundle.putInt("timerLength", timerLength);
        timerIntent.putExtras(bundle);
        startActivity(timerIntent);
    }

    private void createCurrentRecipe(){
        Bundle bundle = getIntent().getExtras();
        recipeList = (List<Beer>) bundle.getSerializable("Recipe List");
        positionInRecipeIndex = bundle.getInt("recipePosition");
        currentRecipe = recipeList.get(positionInRecipeIndex);
    }
}
