package edu.bsu.cs222.cnj.homebrewyo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class IngredientsPage extends AppCompatActivity {

    private Beer currentRecipe;

    List<Beer> recipeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);
        Bundle bundle = getIntent().getExtras();
        recipeList = (List<Beer>) bundle.getSerializable("Recipe List");
        int positionInRecipeIndex = bundle.getInt("recipePosition");
        currentRecipe = recipeList.get(positionInRecipeIndex);

        fillMaltUiInfo();
        fillHopUiInfo();
        fillYeastUiInfo();
    }

    public void fillMaltUiInfo(){
        List<Ingredient> listOfMaltsIngredients = currentRecipe.getMalts();
        ArrayList<String> detailedIngredientList = new ArrayList<>();

        for( int i =0; i < listOfMaltsIngredients.size(); i++){
            String s = listOfMaltsIngredients.get(i).getName();
            s += " | " + listOfMaltsIngredients.get(i).getAmount();
            detailedIngredientList.add(s);
        }

        ListView listviewMalts = (ListView) findViewById(R.id.listView);
        assert listviewMalts != null;
        listviewMalts.setClickable(true);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.listview_layout, R.id.checkBox, detailedIngredientList);
        listviewMalts.setAdapter(arrayAdapter);
    }

    public void fillHopUiInfo(){
        List<Ingredient> listOfHopIngredients = currentRecipe.getHops();
        ArrayList<String> detailedIngredientList = new ArrayList<>();

        for( int i =0; i < listOfHopIngredients.size(); i++){
            String s = listOfHopIngredients.get(i).getName();
            s += " | " + listOfHopIngredients.get(i).getAmount();
            s += " | " + listOfHopIngredients.get(i).getTimingToAdd();
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
        nameTextView.setText(currentRecipe.getYeast().getName());
    }
}
