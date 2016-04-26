package edu.bsu.cs222.cnj.homebrewyo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class IngredientsPage extends AppCompatActivity {

    private Recipe currentRecipe;

    List<Beer> recipeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);
        Bundle bundle = getIntent().getExtras();
        recipeList = (List<Beer>) bundle.getSerializable("Recipe List");
        Log.i("this is from the main ingredients page", recipeList.toString());
        int positionInRecipeIndex = bundle.getInt("recipePosition");
        //runParser(positionInRecipeIndex);

       // fillMaltUiInfo();
       // fillHopUiInfo();
        //fillYeastUiInfo();
    }

    public void runParser(int positionInRecipeIndex){
        XMLFileProcessor parseInfo = new XMLFileProcessor();
        ArrayList<Recipe> listOfRecipies = parseInfo.getListOfRecipes();
        currentRecipe = listOfRecipies.get(positionInRecipeIndex);
    }

    public void fillMaltUiInfo(){
        ArrayList<Malt> listOfMaltsIngredients = currentRecipe.getMaltIngredients();
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
        ArrayList<Hop> listOfHopIngredients = currentRecipe.getHopIngredients();
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
        nameTextView.setText(currentRecipe.getYeastIngredient());
    }
}
