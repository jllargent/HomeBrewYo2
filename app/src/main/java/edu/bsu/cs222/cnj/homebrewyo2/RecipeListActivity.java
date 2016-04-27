package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecipeListActivity extends AppCompatActivity {

    List<Beer> recipeList;
    List<String> beerNamesWithTags;
    int position;
    String sortingTagType;
    String tag ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_recipe_scrollable);
        Bundle bundle = getIntent().getExtras();
        recipeList = (ArrayList<Beer>) bundle.getSerializable("Recipe List");
        sortingTagType = bundle.getString("Sorting Tag");
        createTitleOfPage();
        fillListWithBeerNames();
        sortBeerList();
        createListOfButtons();
    }

    private void createTitleOfPage(){
        TextView sortingTitle = (TextView) findViewById(R.id.textView);
        assert sortingTitle != null;
        sortingTitle.setText(sortingTagType);
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
        clickedName = clickedName.replace("","");
        int i =0;
        do{
            if (clickedName.endsWith(recipeList.get(i).getName())){
                position = i;
                break;
            }
            i++;
        }while( i < recipeList.size());
    }

    public void fillListWithBeerNames(){
        beerNamesWithTags = new ArrayList<>();
        for (int i = 0; i < recipeList.size(); i++){
            addStyleTagIfNeeded(i);
            addDurationTagIfNeeded(i);
            addIBUValueTagIfNeeded(i);
            addABVTagIfNeeded(i);
            beerNamesWithTags.add(tag + recipeList.get(i).getName());
        }

    }

    private void addStyleTagIfNeeded(int index){
        if(sortingTagType.equals("Style")){
            tag = recipeList.get(index).getStyle() + " | ";
        }
    }
    private void addDurationTagIfNeeded(int index){
        if(sortingTagType.equals("Duration In Minutes")){
            tag = Integer.toString(recipeList.get(index).getTimeInMinutes()) + "mins | " ;
        }
    }
    private void addIBUValueTagIfNeeded(int index){
        if(sortingTagType.equals("IBU Value")){
            tag = "IBU:" + Integer.toString(recipeList.get(index).getIbuValue()) + " | " ;
        }
    }
    private void addABVTagIfNeeded(int index){
        if(sortingTagType.equals("ABV Percent")){
            tag = "ABV:" + Double.toString(recipeList.get(index).getABVPercent()) + "% | " ;
        }
    }

    private void createListOfButtons(){
        ListView beerNamesListView = (ListView) findViewById(R.id.listView);
        assert beerNamesListView != null;
        beerNamesListView.setClickable(true);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.name_listview, R.id.button, beerNamesWithTags);
        beerNamesListView.setAdapter(arrayAdapter);
    }

    private void sortBeerList(){
        Collections.sort(beerNamesWithTags);
    }
}
