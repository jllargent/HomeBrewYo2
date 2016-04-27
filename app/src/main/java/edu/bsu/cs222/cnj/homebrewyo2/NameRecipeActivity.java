package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NameRecipeActivity extends AppCompatActivity {

    List<Beer> recipeList;
    List<String> beerNames;
    int position;
    String sortingTagType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_recipe_scrollable);
        Bundle bundle = getIntent().getExtras();
        recipeList = (ArrayList<Beer>) bundle.getSerializable("Recipe List");
        sortingTagType = bundle.getString("Sorting Tag");


        fillListWithBeerNames();
        sortBeerList();
        createListOfButtons();
    }

    public void goBeerRecipe(View view){
        Intent recipeStyleIntent = new Intent(this, RecipePage.class);
        Bundle bundle = new Bundle();
        findButtonPosition(view);
        bundle.putInt("recipePosition", position);
        bundle.putSerializable("Recipe List", (Serializable) recipeList);
        recipeStyleIntent.putExtras(bundle);
        startActivity(recipeStyleIntent);
    }

    private void findButtonPosition(View view) {
        Button button = (Button) view;
        String clickedName = button.getText().toString();
        for(int i = 0; i < beerNames.size(); i++){
            if(clickedName.equalsIgnoreCase(beerNames.get(i))){
                position = i;
                break;
            }
        }
    }

    public void fillListWithBeerNames(){
        beerNames = new ArrayList<>();
        String text ="";
        for (int i = 0; i < recipeList.size(); i++){
            if(sortingTagType.equals("Style")){
                text = recipeList.get(i).getStyle() + " - ";
            }
            if(sortingTagType.equals("Duration")){
                text = Integer.toString(recipeList.get(i).getTimeInMinutes()) + " - " ;
            }
            beerNames.add(text + recipeList.get(i).getName());
        }

    }

    private void createListOfButtons(){
        ListView beerNamesListView = (ListView) findViewById(R.id.listView3);
        assert beerNamesListView != null;
        beerNamesListView.setClickable(true);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.name_listview, R.id.button, beerNames);
        beerNamesListView.setAdapter(arrayAdapter);
    }

    private void sortBeerList(){
        Collections.sort(beerNames);
    }
}
