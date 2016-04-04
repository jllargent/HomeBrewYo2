package edu.bsu.cs222.cnj.homebrewyo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class IngredientsPage extends AppCompatActivity {

    ArrayList<Beer_New> listOfRecipies = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);
        Bundle bundle = getIntent().getExtras();
        int positionInRecipeIndex = bundle.getInt("recipePosition");
        runParser(positionInRecipeIndex);
    }

    public void runParser(int positionInRecipeIndex){
        XMLFileProcessor_New parseInfo = new XMLFileProcessor_New(this);
        listOfRecipies = parseInfo.getListOfBeers();
      //  fillUIInformation(positionInRecipeIndex);
    }

   /* public void fillUIInformation(int positionInRecipeIndex){
        Ingredients currentBeerIngredients = listOfRecipies.get(positionInRecipeIndex);
        setContentView(R.layout.activity_ingredients);

        TextView nameTextView = (TextView) findViewById(R.id.textView15);
        nameTextView.setText(currentBeerIngredients.getYeast());
    }*/
}
