package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DisplayRecipesMain extends AppCompatActivity {

    List<BeerRecipe> recipeList = new ArrayList<>();
    private String sortingTypeTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createPageLayout();
        Bundle bundle = getIntent().getExtras();
        recipeList = (List<BeerRecipe>) bundle.getSerializable("Recipe List");
    }

    public void goRecipeList(View view){
        Intent recipeNameIntent = new Intent(this, RecipeListActivity.class);
        findSortingType(view);
        Bundle bundle = new Bundle();
        placeInfoIntoBundle(bundle);
        recipeNameIntent.putExtras(bundle);
        startActivity(recipeNameIntent);
    }

    private void findSortingType(View view) {
        Button button = (Button) view;
        sortingTypeTag = button.getText().toString();
    }

    private void placeInfoIntoBundle(Bundle bundle){
        bundle.putSerializable("Recipe List", (Serializable) recipeList);
        bundle.putString("Sorting Tag", sortingTypeTag);
    }

    private void createPageLayout(){
        setContentView(R.layout.activity_display_recipes_main);
    }
}
