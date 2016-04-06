package edu.bsu.cs222.cnj.homebrewyo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class IngredientsPage extends AppCompatActivity {

    ArrayList<Beer_New> listOfRecipies = new ArrayList<>();
    ArrayList<Beer_New> listOfMalts = new ArrayList<>();

    private ListView listviewMalts;


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
        fillUIInformation(positionInRecipeIndex);
    }

    public void fillUIInformation(int positionInRecipeIndex){
        Beer_New currentBeerIngredients = listOfRecipies.get(positionInRecipeIndex);
        //listOfMalts.addAll(XMLFileProcessor_New.getListOfBeers());
        //TODO need a function to call the array list for malt

        String[] planets = new String[] { "Mercury", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune"};
        ArrayList<String> list = new ArrayList<>();
        list.addAll( Arrays.asList(planets));

        TextView nameTextView = (TextView) findViewById(R.id.textView15);
        nameTextView.setText(currentBeerIngredients.getYeastIngredient());

        listviewMalts = (ListView) findViewById(R.id.listView);
        listviewMalts.setClickable(true);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, list);
        listviewMalts.setAdapter(arrayAdapter);
    }
}
