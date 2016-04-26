package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NameRecipeActivity extends AppCompatActivity {

    Intent intent = getIntent();
    List<Beer> recipeList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_recipe_scrollable);
        Bundle bundle = getIntent().getExtras();
        recipeList = (List<Beer>) bundle.getSerializable("Recipe List");
        Log.i("Array List", recipeList.toString());
        fillNameList();
    }

    public void goBeerRecipe(View view){
        Intent recipeStyleIntent = new Intent(this, RecipePage.class);
        Bundle bundle = new Bundle();
        bundle.putInt("recipePosition", 0);
        bundle.putSerializable("Recipe List", (Serializable) recipeList);
        recipeStyleIntent.putExtras(bundle);
        startActivity(recipeStyleIntent);
    }

    public void fillNameList(){
        List<String> beerNames = new ArrayList<>();

        for (int i = 0; i < recipeList.size(); i++){
            beerNames.add(recipeList.get(i).getName());
            Log.i("you got beer", beerNames.get(i));
        }


        ListView beerNamesListView = (ListView) findViewById(R.id.listView3);
        assert beerNamesListView != null;
        beerNamesListView.setClickable(true);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.name_listview, R.id.button2, beerNames);
        beerNamesListView.setAdapter(arrayAdapter);

    }
}
