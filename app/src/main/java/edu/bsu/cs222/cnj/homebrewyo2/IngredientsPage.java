package edu.bsu.cs222.cnj.homebrewyo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class IngredientsPage extends AppCompatActivity {

    private ArrayList<Beer_New> listOfRecipies;
    private ArrayList<Malt> listOfMaltsIngredients;
    private ArrayList<Hop> listOfHopIngredients;
    private Beer_New currentBeer;


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
        XMLFileProcessor parseInfo = new XMLFileProcessor(this);
        listOfRecipies = parseInfo.getListOfBeers();
        currentBeer = listOfRecipies.get(positionInRecipeIndex);
    }

    public void fillMaltUiInfo(){
        //TODO need a function to call the array list for malt
        listOfMaltsIngredients = currentBeer.getMaltIngredients();

        String[] planets = new String[] { "Mercury", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune"};
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(planets));


        ListView listviewMalts = (ListView) findViewById(R.id.listView);
        assert listviewMalts != null;
        listviewMalts.setClickable(true);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, list);
        listviewMalts.setAdapter(arrayAdapter);
    }

    public void fillHopUiInfo(){
        listOfHopIngredients = currentBeer.getHopIngredients();

    }
    public void fillYeastUiInfo() {
        TextView nameTextView = (TextView) findViewById(R.id.textView15);
        assert nameTextView != null;
        nameTextView.setText(currentBeer.getYeastIngredient());
    }
}
