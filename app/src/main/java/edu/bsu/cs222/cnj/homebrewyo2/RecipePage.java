package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class RecipePage extends AppCompatActivity {

    private Button timeSet;
    ArrayList<Beer> listOfRecipies = new ArrayList<>();

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
        Intent onClick = new Intent(this, IngredientsPage.class);
        startActivity(onClick);
    }

    public void runParser(int positionInRecipeIndex){
        XMLFileProcessor_New parseInfo = new XMLFileProcessor_New(this);
        listOfRecipies = parseInfo.getListOfBeers();
        fillUIInformation(positionInRecipeIndex);
        /*
        Log.i("Testing Info Title", listOfRecipies.get(0).getTitleOfBeer());

        Log.i("Testing Info Style", listOfRecipies.get(0).getStyleOfBeer());

        Log.i("Testing Info Descriptio", listOfRecipies.get(0).getDescriptionOfBeer());*/
    }

    public void fillUIInformation(int positionInRecipeIndex) {
        Beer currentBeer = listOfRecipies.get(positionInRecipeIndex);
        setContentView(R.layout.activity_recipe);
        TextView nameTextView = (TextView) findViewById(R.id.textView16);
        nameTextView.setText(currentBeer.getTitleOfBeer());

        TextView descriptionTextView = (TextView) findViewById(R.id.textView);
        descriptionTextView.setText(currentBeer.getDescriptionOfBeer());

      /*
        TextView timeTextView = (TextView) findViewById(R.id.textView3);
        timeTextView.setText();

        TextView fermentTextView = (TextView) findViewById(R.id.textView4);
        fermentTextView.setText();

        TextView abvTextView = (TextView) findViewById(R.id.textView5);
        abvTextView.setText();

        TextView oGravTextView = (TextView) findViewById(R.id.textView6);
        oGravTextView.setText();

        TextView fGravTextView = (TextView) findViewById(R.id.textView7);
        fGravTextView.setText();*/

    }
}
