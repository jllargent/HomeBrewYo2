package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class RecipePage extends AppCompatActivity {

    private Button timeSet;
    ArrayList<Beer_New> listOfRecipies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        Bundle bundle = getIntent().getExtras();
        int positionInRecipeIndex = bundle.getInt("recipePosition");
        runParser(positionInRecipeIndex);

        timeSet = (Button) findViewById(R.id.badPixTimer);
        timeSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimerActivity.setTime(75 * 60);
            }
        });
    }

    public void goBadPixieIngredients(View view){
        int positionInRecipeIndex = Integer.parseInt(String.valueOf(view.getTag()));
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
}
