package edu.bsu.cs222.cnj.homebrewyo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class IngredientsPage extends AppCompatActivity {

    private ArrayList<Beer> listOfRecipies;
    private ArrayList<Malt> listOfMaltsIngredients;
    private ArrayList<Hop> listOfHopIngredients;
    private Beer currentBeer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);
        Bundle bundle = getIntent().getExtras();
        int positionInRecipeIndex = bundle.getInt("recipePosition");
        runParser(positionInRecipeIndex);

        fillMaltUiInfo();
        fillHopUiInfo();
        fillYeastUiInfo();
    }

    public void runParser(int positionInRecipeIndex){
        XMLFileProcessor parseInfo = new XMLFileProcessor();
        listOfRecipies = parseInfo.getListOfBeers();
        currentBeer = listOfRecipies.get(positionInRecipeIndex);
    }

    public void fillMaltUiInfo(){
        //TODO need a function to call the array list for malt
        listOfMaltsIngredients = currentBeer.getMaltIngredients();
        ArrayList<String> detailedIngredientList = new ArrayList<>();
        for( int i =0; i < listOfMaltsIngredients.size(); i++){
            String s = listOfMaltsIngredients.get(i).getNameOfMalt();
            s += " | " + listOfMaltsIngredients.get(i).getAmountOfMalt();
            detailedIngredientList.add(s);
        }

        ListView listviewMalts = (ListView) findViewById(R.id.listView);
        assert listviewMalts != null;
        listviewMalts.setClickable(true);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.listview_layout, R.id.checkBox, detailedIngredientList);
        listviewMalts.setAdapter(arrayAdapter);
    }

    public void fillHopUiInfo(){
        listOfHopIngredients = currentBeer.getHopIngredients();
        ArrayList<String> detailedIngredientList = new ArrayList<>();
        for( int i =0; i < listOfHopIngredients.size(); i++){
            String s = listOfHopIngredients.get(i).getNameOfHop();
            s += " | " + listOfHopIngredients.get(i).getAmountOfHops();
            s += " | " + listOfHopIngredients.get(i).getTimeToAddHop();
            detailedIngredientList.add(s);
        }
        ListView listviewMalts = (ListView) findViewById(R.id.listView2);
        assert listviewMalts != null;
        listviewMalts.setClickable(true);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.listview_layout, R.id.checkBox, detailedIngredientList);
        listviewMalts.setAdapter(arrayAdapter);
    }

    public void fillYeastUiInfo() {
        TextView nameTextView = (TextView) findViewById(R.id.textView15);
        assert nameTextView != null;
        nameTextView.setText(currentBeer.getYeastIngredient());
    }
}
