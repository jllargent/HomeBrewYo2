package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class RecipePage extends AppCompatActivity {

    private int positionInRecipeIndex;

    ArrayList<Beer> listOfRecipies = new ArrayList<>();

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
        XMLFileProcessor parseInfo = new XMLFileProcessor();
        listOfRecipies = parseInfo.getListOfBeers();
        fillUIInformation(positionInRecipeIndex);
    }

    //TODO: Clean Up DRY Violation
    public void fillUIInformation(int positionInRecipeIndex) {
        Beer currentBeer = listOfRecipies.get(positionInRecipeIndex);
        setContentView(R.layout.activity_recipe);
        TextView nameTextView = (TextView) findViewById(R.id.textView16);
        assert nameTextView != null;
        nameTextView.setText(currentBeer.getTitleOfBeer());

        TextView descriptionTextView = (TextView) findViewById(R.id.textView);
        assert descriptionTextView != null;
        descriptionTextView.setText(currentBeer.getDescriptionOfBeer());


        TextView boilTimeTextView = (TextView) findViewById(R.id.textView3);
        assert boilTimeTextView != null;
        boilTimeTextView.setText(currentBeer.getBoilDescription());


        TextView fermentTextView = (TextView) findViewById(R.id.textView4);
        assert fermentTextView != null;
        fermentTextView.setText(currentBeer.getFermentTemp());


        TextView abvTextView = (TextView) findViewById(R.id.textView5);
        assert abvTextView != null;
        abvTextView.setText(currentBeer.getValueOfABV());


        TextView oGravTextView = (TextView) findViewById(R.id.textView7);
        assert oGravTextView != null;
        oGravTextView.setText(currentBeer.getOriginalGravity());


        TextView fGravTextView = (TextView) findViewById(R.id.textView8);
        assert fGravTextView != null;
        fGravTextView.setText(currentBeer.getFinalGravity());
    }

    public void goTimer(View view){
        Beer currentBeer = listOfRecipies.get(positionInRecipeIndex);
        int timerLength = currentBeer.getTimeInMins() * 60;
        Intent timerIntent = new Intent(this, TimerActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("timerLength", timerLength);
        timerIntent.putExtras(bundle);
        startActivity(timerIntent);

    }

    //TODO for iteration 3 create new button. this button marks it as the current beer you are working on. It takes all the info from the currentbeer and creates a new arraylist of the info. new screen then uses the info from that arraylist.

}
