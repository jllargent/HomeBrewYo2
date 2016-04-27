package edu.bsu.cs222.cnj.homebrewyo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TimerActivity extends AppCompatActivity {

    private TextView textViewTime;
    private Time time = new Time();
    private Counter decrement;
    private Button buttonStart;
    private Button buttonStop;
    long countDownInterval = 1000;
    private List<Beer> recipeList;
    private Beer currentRecipe;

    public TimerActivity(){
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpTimerForCurrentBeer();
        setUpPage();

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isCurrentButtonTitle("RESUME")){
                    decrement = new Counter(time);
                    decrement.start();
                    buttonStart.setText("RESTART");
                }
                else if(isCurrentButtonTitle("RESTART")) {
                    decrement.cancel();
                    time.setCurrentTime(time.getInitialTime());
                    decrement = new Counter(time);
                    decrement.cancel();
                    buttonStart.setText("START");
                }
                else if(isCurrentButtonTitle("START")){
                    decrement.start();
                    buttonStart.setText("RESTART");
                }
                decrement.setActContext(TimerActivity.this);
                decrement.setViewTime(textViewTime);
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrement.cancel();
                time.setCurrentTime(decrement.getMilliSecondsLeft());
                buttonStart.setText("RESUME");
            }
        });
    }

    public TextView getTimerText(){
        return textViewTime;
    }

    boolean isCurrentButtonTitle(String titleOfButton){
        return buttonStart.getText().equals(titleOfButton);
    }

    public void setUpTimerForCurrentBeer(){
        setContentView(R.layout.activity_timer);
        Bundle bundle = getIntent().getExtras();
        recipeList = (List<Beer>) bundle.getSerializable("Recipe List");
        int positionInRecipeIndex = bundle.getInt("recipePosition");

        currentRecipe = recipeList.get(positionInRecipeIndex);

        time.setInitialTime(bundle.getInt("timerLength") * 1000);
        time.setCountDownInterval(countDownInterval);
        time.setCurrentTime(time.getInitialTime());
        fillHopUiInfo();
        decrement = new Counter(time);
    }
    public void setUpPage(){
        buttonStart = (Button) findViewById(R.id.btnStart);
        buttonStop = (Button) findViewById(R.id.btnStop);
        textViewTime = (TextView) findViewById(R.id.timer1);
        decrement.setViewTime(textViewTime);
        buttonStart.setText("START");
    }
    public void fillHopUiInfo(){
        List<Ingredient> listOfHopIngredients = currentRecipe.getHops();
        ArrayList<String> detailedIngredientList = new ArrayList<>();

        for( int i =0; i < listOfHopIngredients.size(); i++){
            String s = listOfHopIngredients.get(i).getName();
            s += " | " + listOfHopIngredients.get(i).getAmount() + "g";
            s += " | " + listOfHopIngredients.get(i).getTimingToAdd();
            detailedIngredientList.add(s);
        }

        ListView listviewMalts = (ListView) findViewById(R.id.listView3);
        assert listviewMalts != null;
        listviewMalts.setClickable(true);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.listview_layout, R.id.checkBox, detailedIngredientList);
        listviewMalts.setAdapter(arrayAdapter);
    }
}