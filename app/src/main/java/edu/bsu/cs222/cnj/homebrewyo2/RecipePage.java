package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class RecipePage extends AppCompatActivity {

    private BeerRecipe currentRecipe;
    private TextView currentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createPageLayout();
        createCurrentRecipe();
        fillUIInformation();
    }

    public void goTimer(View view){
        Intent timerIntent = new Intent(this, TimerActivity.class);
        storeCurrentRecipeInIntent(timerIntent);
        startActivity(timerIntent);
    }
    public void goIngredients(View view){
        Intent recipeStyleIntent = new Intent(this, IngredientsPage.class);
        storeCurrentRecipeInIntent(recipeStyleIntent);
        startActivity(recipeStyleIntent);
    }

    private void createPageLayout(){
        setContentView(R.layout.activity_recipe);
    }
    private void createCurrentRecipe(){
        Bundle bundle = getIntent().getExtras();
        List<BeerRecipe> recipeList = (List<BeerRecipe>) bundle.getSerializable("Recipe List");
        int positionInRecipeIndex = bundle.getInt("recipePosition");
        if (recipeList != null) {
            currentRecipe = recipeList.get(positionInRecipeIndex);
        }
    }

    private void storeCurrentRecipeInIntent(Intent intent){
        Bundle bundle = new Bundle();
        bundle.putSerializable("Current Recipe", currentRecipe);
        intent.putExtras(bundle);
    }

    private void fillUIInformation() {
        setNameText();
        setStyleText();
        setDescriptionText();
        setBoilTimeText();
        setFermentText();
        setABVAndIBUText();
        setOriginalGravityText();
        setFinalGravityText();
    }

    private void setNameText(){
        currentTextView = (TextView) findViewById(R.id.beerTitle);
        assert currentTextView != null;
        currentTextView.setText(currentRecipe.getName());
    }

    private void setStyleText(){
        currentTextView = (TextView) findViewById(R.id.styleText);
        assert currentTextView != null;
        currentTextView.setText(" " + currentRecipe.getStyle());
    }

    private void setDescriptionText(){
        currentTextView = (TextView) findViewById(R.id.description);
        assert currentTextView != null;
        currentTextView.setText(currentRecipe.getDescription());
    }

    private void setBoilTimeText(){
        currentTextView = (TextView) findViewById(R.id.boilText);
        String s = "Boil for " + currentRecipe.getTimeInMinutes() + " minutes at ";
        s += currentRecipe.getTemperatureInFahrenheit() + "F";
        assert currentTextView != null;
        currentTextView.setText(s);
    }

    private void setFermentText(){
        currentTextView = (TextView) findViewById(R.id.fermentText);
        assert currentTextView != null;
        currentTextView.setText("Ferment at " + currentRecipe.getFermentTemperature() + "F");
    }

    private void setABVAndIBUText(){
        currentTextView = (TextView) findViewById(R.id.abvText);
        assert currentTextView != null;
        String abv = "ABV: " + currentRecipe.getABVPercent() + "% | ";
        String ibu = "IBU: " + currentRecipe.getIbuValue();
        currentTextView.setText(abv + ibu);
    }

    private void setOriginalGravityText(){
        currentTextView = (TextView) findViewById(R.id.oGravityText);
        assert currentTextView != null;
        String text = "Original Gravity: ";
        text += currentRecipe.getTargetOriginalGravity();
        currentTextView.setText(text);
    }

    private void setFinalGravityText(){
        currentTextView = (TextView) findViewById(R.id.fGravityText);
        assert currentTextView != null;
        String text = "Final Gravity: ";
        text += currentRecipe.getTargetFinalGravity();
        currentTextView.setText(text);
    }
}
