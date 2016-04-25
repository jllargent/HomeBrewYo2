package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NameRecipeActivity extends AppCompatActivity {

    Intent intent = getIntent();
    List<Beer> recipeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_recipe_scrollable);
        Bundle bundle = getIntent().getExtras();
        recipeList = (List<Beer>) bundle.getSerializable("Recipe List");
        fillNameList();
    }

    private void createButtonList() {

    }

    public void goBeerRecipe(View view){
        int positionInRecipeIndex = Integer.parseInt(String.valueOf(view.getTag()));
        Intent recipeStyleIntent = new Intent(this, RecipePage.class);
        Bundle bundle = new Bundle();
        bundle.putInt("recipePosition", positionInRecipeIndex);
        recipeStyleIntent.putExtras(bundle);
        startActivity(recipeStyleIntent);
    }

    public void fillNameList(){
        List<String> beerNames = new ArrayList<>();

        int i = 0;
        while(beerNames.size() < recipeList.size()){
            beerNames.add(recipeList.get(i).getName());
            i++;
            Log.i("Beer Name", beerNames.get(i));
        }



    }

}
