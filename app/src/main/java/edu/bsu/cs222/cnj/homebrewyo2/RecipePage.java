package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class RecipePage extends AppCompatActivity {

    private int positionInRecipeIndex;

    ArrayList<Beer_New> listOfRecipies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        Bundle bundle = getIntent().getExtras();
        positionInRecipeIndex = bundle.getInt("recipePosition");
        runParser(positionInRecipeIndex);
    }

    public void goIngredients(View view){
        Intent recipeStyleIntent = new Intent(this, IngredientsPage.class);
        Bundle bundle = new Bundle();
        bundle.putInt("recipePosition", positionInRecipeIndex);
        recipeStyleIntent.putExtras(bundle);
        startActivity(recipeStyleIntent);
    }

    public void runParser(int positionInRecipeIndex){
        XMLFileProcessor_New parseInfo = new XMLFileProcessor_New(this);
        listOfRecipies = parseInfo.getListOfBeers();
        fillUIInformation(positionInRecipeIndex);

    }


    public void fillUIInformation(int positionInRecipeIndex) {
        Beer_New currentBeer = listOfRecipies.get(positionInRecipeIndex);
        setContentView(R.layout.activity_recipe);
        TextView nameTextView = (TextView) findViewById(R.id.textView16);
        nameTextView.setText(currentBeer.getTitleOfBeer());

        TextView descriptionTextView = (TextView) findViewById(R.id.textView);
        descriptionTextView.setText(currentBeer.getDescriptionOfBeer());


        TextView boilTimeTextView = (TextView) findViewById(R.id.textView3);
        boilTimeTextView.setText(currentBeer.getBoilDescription());


        TextView fermentTextView = (TextView) findViewById(R.id.textView4);
        fermentTextView.setText(currentBeer.getFermentTemp());


        TextView abvTextView = (TextView) findViewById(R.id.textView5);
        abvTextView.setText(currentBeer.getValueOfABV());


        TextView oGravTextView = (TextView) findViewById(R.id.textView7);
        oGravTextView.setText(currentBeer.getOriginalGravity());


        TextView fGravTextView = (TextView) findViewById(R.id.textView8);
        fGravTextView.setText(currentBeer.getFinalGravity());

    }

    public void goTimer(View view){
        Beer_New currentBeer = listOfRecipies.get(positionInRecipeIndex);
        int timerLength = currentBeer.getTimeInMins() * 60;
        Intent timerIntent = new Intent(this, TimerActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("timerLength", timerLength);
        timerIntent.putExtras(bundle);
        startActivity(timerIntent);

    }

}
