package edu.bsu.cs222.cnj.homebrewyo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class IngredientsPage extends AppCompatActivity {

    private BeerRecipe currentRecipe;
    private List<String> detailedIngredientList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createPage();
        createCurrentRecipe();
        fillMaltUiInfo();
        fillHopUiInfo();
        fillYeastUiInfo();
    }

    public void fillMaltUiInfo(){
        List<Ingredient> listOfMaltsIngredients = currentRecipe.getMalts();
        ListView listViewMalts = (ListView) findViewById(R.id.listViewMalts);
        createListOfDetailedIngredients(listOfMaltsIngredients);
        placeListInUI(listViewMalts);
    }

    public void fillHopUiInfo(){
        List<Ingredient> listOfHopIngredients = currentRecipe.getHops();
        ListView listViewHops = (ListView) findViewById(R.id.listViewHops);
        createListOfDetailedIngredients(listOfHopIngredients);
        placeListInUI(listViewHops);
    }

    public void fillYeastUiInfo() {
        TextView nameTextView = (TextView) findViewById(R.id.yeastTextView);
        assert nameTextView != null;
        nameTextView.setText(currentRecipe.getYeast().getName());
    }

    private void createListOfDetailedIngredients(List<Ingredient> listOfIngredients){
        detailedIngredientList = new ArrayList<>();
        for( int i =0; i < listOfIngredients.size(); i++){
            String s = listOfIngredients.get(i).getName();
            s += " | " + listOfIngredients.get(i).getAmount();
            if(listOfIngredients.get(i).getTimingToAdd() != null) {
                s += "g | " + listOfIngredients.get(i).getTimingToAdd();
            }
            else{
                s += "lb";
            }
            detailedIngredientList.add(s);
        }
    }
    private void placeListInUI(ListView listView){
        assert listView != null;
        listView.setClickable(true);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.listview_layout, R.id.checkBox, detailedIngredientList);
        listView.setAdapter(arrayAdapter);
    }

    private void createCurrentRecipe(){
        Bundle bundle = getIntent().getExtras();
        currentRecipe = (BeerRecipe) bundle.getSerializable("Current Recipe");
    }

    private void createPage(){
        setContentView(R.layout.activity_ingredients);
    }
}
